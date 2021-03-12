package com.quarkusredissontester.repositories;

import com.quarkusredissontester.entities.compression.Lz4RedisCodec;
import com.quarkusredissontester.entities.compression.SnappyRedisCodec;
import io.lettuce.core.ClientOptions;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.reactive.RedisHashReactiveCommands;
import io.lettuce.core.api.reactive.RedisServerReactiveCommands;
import io.lettuce.core.api.reactive.RedisStringReactiveCommands;
import io.lettuce.core.cluster.ClusterClientOptions;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.codec.RedisCodec;
import io.lettuce.core.codec.StringCodec;
import io.lettuce.core.resource.ClientResources;
import io.lettuce.core.resource.Delay;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import reactor.core.publisher.Flux;

import javax.inject.Singleton;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class LettuceConfiguration {

    @ConfigProperty( name = "redis.url.single")
    String redisSingleNodeUrl;

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

    //https://lettuce.io/core/release/reference/#_connection_pooling
    //Nothing ready for reactive connections dixit missing doc, only sync/async
    @ConfigProperty( name = "redis.connection.pool.size")
    Integer connectionPoolSize;


    private static final int DEFAULT_PORT = 6379;
    private static final String ID_TEMPLATE = "{id}";
    private static final Map<String, RedisCodec> CODECS = Map.of(
            "NONE", new StringCodec(),
            "LZ4", new Lz4RedisCodec(new StringCodec()),
            "SNAPPY", new SnappyRedisCodec(new StringCodec()));


    @Singleton
    public RedisStringReactiveCommands<String, String> reactiveCommands() {
        ClientResources clientResources = ClientResources.builder()
                .ioThreadPoolSize(nbThreads) //no real computation on our side in DB, right?
                .reconnectDelay(Delay.constant(Duration.ofMillis(retryInterval)))
        .build();

        if (nodesNumber == 1) {
            log.info("Connecting to a single Redis node with Lettuce and url:{}", redisSingleNodeUrl);

            RedisClient client = RedisClient.create(clientResources,
                    "redis://" + redisSingleNodeUrl + ":" + DEFAULT_PORT);
            client.setDefaultTimeout(Duration.ofMillis(timeout));

            client.setOptions(ClientOptions.builder()
                    .build());

            return client.connect(CODECS.getOrDefault(codec, new StringCodec())).reactive();
        } else {
            log.info("Connecting to a cluster of Redis nodes with Lettuce, {} nodes and template url:{}", nodesNumber, redisSingleNodeUrl);

            List<RedisURI> nodesUri = new ArrayList<>(nodesNumber);

            Flux.range(0, nodesNumber).doOnNext(nodesNumber -> nodesUri.add(
                    new RedisURI(redisClusterUrl.replace(ID_TEMPLATE, String.valueOf(nodesNumber)),
                            DEFAULT_PORT, Duration.ofMillis(timeout))))
                    .subscribe();

            RedisClusterClient client = RedisClusterClient.create(nodesUri);
            client.setDefaultTimeout(Duration.ofMillis(timeout));

            client.setOptions(ClusterClientOptions.builder()
                    .build());

            return client.connect(CODECS.getOrDefault(codec, new StringCodec())).reactive();
        }
    }


    //HACK as Quarkus DI seems stricter than the one from Micronaut
    @Singleton
    public RedisHashReactiveCommands<String, String> reactiveHashCommands() {
        ClientResources clientResources = ClientResources.builder()
                .ioThreadPoolSize(nbThreads) //no real computation on our side in DB, right?
                .reconnectDelay(Delay.constant(Duration.ofMillis(retryInterval)))
                .build();

        if (nodesNumber == 1) {
            log.info("Connecting to a single Redis node with Lettuce and url:{}", redisSingleNodeUrl);

            RedisClient client = RedisClient.create(clientResources,
                    "redis://" + redisSingleNodeUrl + ":" + DEFAULT_PORT);
            client.setDefaultTimeout(Duration.ofMillis(timeout));

            client.setOptions(ClientOptions.builder()
                    .build());

            return client.connect(CODECS.getOrDefault(codec, new StringCodec())).reactive();
        } else {
            log.info("Connecting to a cluster of Redis nodes with Lettuce, {} nodes and template url:{}", nodesNumber, redisSingleNodeUrl);

            List<RedisURI> nodesUri = new ArrayList<>(nodesNumber);

            Flux.range(0, nodesNumber).doOnNext(nodesNumber -> nodesUri.add(
                    new RedisURI(redisClusterUrl.replace(ID_TEMPLATE, String.valueOf(nodesNumber)),
                            DEFAULT_PORT, Duration.ofMillis(timeout))))
                    .subscribe();

            RedisClusterClient client = RedisClusterClient.create(nodesUri);
            client.setDefaultTimeout(Duration.ofMillis(timeout));

            client.setOptions(ClusterClientOptions.builder()
                    .build());

            return client.connect(CODECS.getOrDefault(codec, new StringCodec())).reactive();
        }
    }

    //HACK as Quarkus DI seems stricter than the one from Micronaut
    @Singleton
    public RedisServerReactiveCommands<String, String> serverReactiveCommands() {
        ClientResources clientResources = ClientResources.builder()
                .ioThreadPoolSize(nbThreads) //no real computation on our side in DB, right?
                .reconnectDelay(Delay.constant(Duration.ofMillis(retryInterval)))
                .build();

        if (nodesNumber == 1) {
            log.info("Connecting to a single Redis node with Lettuce and url:{}", redisSingleNodeUrl);

            RedisClient client = RedisClient.create(clientResources,
                    "redis://" + redisSingleNodeUrl + ":" + DEFAULT_PORT);
            client.setDefaultTimeout(Duration.ofMillis(timeout));

            client.setOptions(ClientOptions.builder()
                    .build());

            return client.connect(CODECS.getOrDefault(codec, new StringCodec())).reactive();
        } else {
            log.info("Connecting to a cluster of Redis nodes with Lettuce, {} nodes and template url:{}", nodesNumber, redisSingleNodeUrl);

            List<RedisURI> nodesUri = new ArrayList<>(nodesNumber);

            Flux.range(0, nodesNumber).doOnNext(nodesNumber -> nodesUri.add(
                    new RedisURI(redisClusterUrl.replace(ID_TEMPLATE, String.valueOf(nodesNumber)),
                            DEFAULT_PORT, Duration.ofMillis(timeout))))
                    .subscribe();

            RedisClusterClient client = RedisClusterClient.create(nodesUri);
            client.setDefaultTimeout(Duration.ofMillis(timeout));

            client.setOptions(ClusterClientOptions.builder()
                    .build());

            return client.connect(CODECS.getOrDefault(codec, new StringCodec())).reactive();
        }
    }
}
