package com.webfluxredissonredistester.repositories;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.client.codec.Codec;
import org.redisson.client.codec.StringCodec;
import org.redisson.codec.LZ4Codec;
import org.redisson.codec.SnappyCodecV2;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import reactor.core.publisher.Flux;

import java.util.Map;

@Configuration
@Slf4j
public class RedissonConfiguration {

    @Value("${redis.url.single}")
    private String redisSingleNodeUrl;

    @Value("${redis.url.cluster.template}")
    private String redisClusterUrl;

    @Value("${redis.nodes.number}")
    private Integer nodesNumber;

    @Value("${redis.codec}")
    private String codec;

    @Value("${redis.threads.number}")
    private Integer nbThreads;

    @Value("${redis.retry.interval}")
    private Integer retryInterval;

    @Value("${redis.retry.attempts}")
    private Integer retryAttempts;

    @Value("${redis.connection.pool.size}")
    private Integer connectionPoolSize;


    private static final int DEFAULT_PORT = 6379;
    private static final String ID_TEMPLATE = "{id}";
    private static final Map<String, Codec> CODECS = Map.of(
            "NONE", new StringCodec(),
            "LZ4", new LZ4Codec(),
            "SNAPPY", new SnappyCodecV2());


    @Bean
    public ReactiveRedisTemplate<String, String> reactiveRedisStringTemplate() {
        StringRedisSerializer keySerializer = new StringRedisSerializer();

        RedisSerializationContext.RedisSerializationContextBuilder<String, String> builder =
                RedisSerializationContext.newSerializationContext(keySerializer);

        RedisSerializationContext<String, String> context = builder.value(keySerializer).build();

        return new ReactiveRedisTemplate<>(redissonConnectionFactory(), context);
    }


    @Bean
    public ReactiveRedisConnectionFactory redissonConnectionFactory() {
        return new RedissonConnectionFactory(getConfig());
    }

    @Bean
    public RedissonReactiveClient redissonReactiveClient() {
        return Redisson.createReactive(getConfig());
    }

    private Config getConfig() {
        Config config = new Config();
        config.setNettyThreads(nbThreads);
        config.setCodec(CODECS.getOrDefault(codec, new StringCodec()));

        if (nodesNumber == 1) {
            SingleServerConfig singleServerConfig = config.useSingleServer();
            singleServerConfig.setAddress("redis://" + redisSingleNodeUrl + ":" + DEFAULT_PORT);

            singleServerConfig.setConnectionPoolSize(connectionPoolSize);
            singleServerConfig.setRetryAttempts(retryAttempts);
            singleServerConfig.setRetryInterval(retryInterval);

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
        }
        return config;
    }
}
