package com.quarkusredissontester.repositories;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.redisson.Redisson;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.client.codec.Codec;
import org.redisson.client.codec.StringCodec;
import org.redisson.codec.LZ4Codec;
import org.redisson.codec.SnappyCodecV2;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import reactor.core.publisher.Flux;

import javax.enterprise.context.ApplicationScoped;
import java.util.Map;

@Slf4j
public class RedissonConfiguration {

    @ConfigProperty( name = "redis.url.single")
    String redisSingleNodeUrl; //no private as it forces Quarkus to use reflection to inject it

    @ConfigProperty( name = "redis.url.cluster.template")
    String redisClusterUrl;

    @ConfigProperty( name = "redis.nodes.number")
    Integer nodesNumber;

    @ConfigProperty( name = "redis.codec")
    String codec;

    @ConfigProperty( name = "redis.threads.number")
    Integer nbThreads;

    @ConfigProperty( name = "redis.retry.interval")
    Integer retryInterval;

    @ConfigProperty( name = "redis.retry.attempts")
    Integer retryAttempts;

    @ConfigProperty( name = "redis.timeout")
    Integer timeout;

    @ConfigProperty( name = "redis.connection.pool.size")
    Integer connectionPoolSize;


    private static final int DEFAULT_PORT = 6379;
    private static final String ID_TEMPLATE = "{id}";
    private static final Map<String, Codec> CODECS = Map.of(
            "NONE", new StringCodec(),
            "LZ4", new LZ4Codec(),
            "SNAPPY", new SnappyCodecV2());



    @ApplicationScoped
    public RedissonReactiveClient redissonReactiveClient() {
        Config config = new Config();
        config.setNettyThreads(nbThreads);
        config.setCodec(CODECS.getOrDefault(codec, new StringCodec()));
        log.info("Using codec:{}", config.getCodec());

        if (nodesNumber == 1) {
            SingleServerConfig singleServerConfig = config.useSingleServer();
            singleServerConfig.setAddress("redis://" + redisSingleNodeUrl + ":" + DEFAULT_PORT);

            singleServerConfig.setConnectionPoolSize(connectionPoolSize);
            singleServerConfig.setRetryAttempts(retryAttempts);
            singleServerConfig.setRetryInterval(retryInterval);
            singleServerConfig.setTimeout(timeout);

            log.info("Connecting to a single Redis node using Redisson and url:{}", redisSingleNodeUrl);
        } else {
            log.info("Connecting to a cluster of Redis nodes with Redisson, {} nodes and template url:{}", nodesNumber, redisSingleNodeUrl);
            ClusterServersConfig clusterServersConfig = config.useClusterServers();

            Flux.range(0, nodesNumber).doOnNext(nodesNumber -> clusterServersConfig.addNodeAddress(
                    "redis://" + redisClusterUrl.replace(ID_TEMPLATE, String.valueOf(nodesNumber)) + ":" + DEFAULT_PORT))
                    .subscribe();

            clusterServersConfig.setRetryAttempts(retryAttempts);
            clusterServersConfig.setRetryInterval(retryInterval);
            clusterServersConfig.setMasterConnectionPoolSize(connectionPoolSize);
            clusterServersConfig.setSlaveConnectionPoolSize(connectionPoolSize); //More for reading on slaves? we'll see
            clusterServersConfig.setTimeout(timeout);
        }

        return Redisson.createReactive(config);
    }
}
