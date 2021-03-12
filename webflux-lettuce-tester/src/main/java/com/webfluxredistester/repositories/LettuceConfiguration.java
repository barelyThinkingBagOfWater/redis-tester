package com.webfluxredistester.repositories;

import com.webfluxredistester.entities.compression.LZ4CompressionService;
import com.webfluxredistester.entities.compression.SnappyCompressionService;
import io.lettuce.core.ReadFrom;
import io.lettuce.core.resource.ClientResources;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.data.redis.serializer.RedisSerializationContext.newSerializationContext;

@Configuration
@Slf4j
public class LettuceConfiguration {

    @Value("${redis.url.single}")
    private String redisSingleNodeUrl;

    @Value("${redis.url.cluster.template}")
    private String redisClusterUrl;

    @Value("${redis.nodes.number}")
    private Integer nodesNumber;

    @Value("${redis.threads.number}")
    private Integer numberThreads;

    @Value("${redis.codec}")
    private String codec;


    private static final int DEFAULT_PORT = 6379;
    private static final String ID_TEMPLATE = "{id}";
    private static final Map<String, RedisSerializer> CODECS = Map.of(
            "NONE", new StringRedisSerializer(),
            "LZ4", new CustomRedisSerializer(new LZ4CompressionService()),
            "SNAPPY", new CustomRedisSerializer(new SnappyCompressionService()));

    @Bean
    public ReactiveRedisTemplate<String, String> reactiveRedisStringTemplate() {
        RedisSerializationContext.RedisSerializationContextBuilder<String, String> builder =
                newSerializationContext(CODECS.getOrDefault(codec, new StringRedisSerializer()));

        RedisSerializationContext<String, String> context = builder
                .key(new StringRedisSerializer())
//                .value(CODECS.getOrDefault(codec, new StringRedisSerializer()))
                .build();

        return new ReactiveRedisTemplate<>(lettuceConnectionFactory(), context);
    }


    @Bean
    public ReactiveRedisConnectionFactory lettuceConnectionFactory() {
        LettuceClientConfiguration clientConfiguration = LettuceClientConfiguration
                .builder()
                .clientResources(ClientResources.builder()
                        .ioThreadPoolSize(numberThreads)
                        .build())
                .readFrom(ReadFrom.REPLICA_PREFERRED)
                .build();

        if (nodesNumber == 1) {
            log.info("Connecting to a single Redis node with Lettuce and url:{}", redisSingleNodeUrl);

            RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
            configuration.setHostName(redisSingleNodeUrl);
            configuration.setPort(DEFAULT_PORT);

            return new LettuceConnectionFactory(configuration, clientConfiguration);
        } else {
            log.info("Connecting to a cluster of Redis nodes with Lettuce, {} nodes and template url:{}", nodesNumber, redisSingleNodeUrl);

            RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
            List<RedisNode> redisNodes = new ArrayList<>(nodesNumber);

            Flux.range(0, nodesNumber).doOnNext(nodesNumber -> redisNodes.add(
                    new RedisNode(redisClusterUrl.replace(ID_TEMPLATE, String.valueOf(nodesNumber)), DEFAULT_PORT)))
                    .subscribe();

            redisClusterConfiguration.setClusterNodes(redisNodes);

            return new LettuceConnectionFactory(redisClusterConfiguration, clientConfiguration);
        }
    }
}
