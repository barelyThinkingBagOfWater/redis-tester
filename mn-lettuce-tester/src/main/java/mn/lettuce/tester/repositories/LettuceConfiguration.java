package mn.lettuce.tester.repositories;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.reactive.RedisStringReactiveCommands;
import io.lettuce.core.cluster.ClusterClientOptions;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.codec.RedisCodec;
import io.lettuce.core.codec.StringCodec;
import io.lettuce.core.resource.ClientResources;
import io.lettuce.core.resource.Delay;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import mn.lettuce.tester.entities.compression.Lz4RedisCodec;
import mn.lettuce.tester.entities.compression.SnappyRedisCodec;
import reactor.core.publisher.Flux;

import javax.inject.Singleton;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Factory
public class LettuceConfiguration {

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

    @Value("${redis.timeout}")
    private Integer timeout;

    //https://lettuce.io/core/release/reference/#_connection_pooling
    //Nothing ready for reactive connections dixit missing doc, only sync/async
    @Value("${redis.connection.pool.size}")
    private Integer connectionPoolSize;


    private static final int DEFAULT_PORT = 6379;
    private static final String ID_TEMPLATE = "{id}";
    private static final Map<String, RedisCodec> CODECS = Map.of(
            "NONE", new StringCodec(),
            "LZ4", new Lz4RedisCodec(new StringCodec()),
            "SNAPPY", new SnappyRedisCodec(new StringCodec()));



    @Singleton
    public RedisStringReactiveCommands reactiveCommands() {

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
