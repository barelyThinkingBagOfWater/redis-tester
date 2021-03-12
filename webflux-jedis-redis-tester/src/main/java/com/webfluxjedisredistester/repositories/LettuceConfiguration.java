package com.webfluxjedisredistester.repositories;

import io.lettuce.core.ReadFrom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
public class LettuceConfiguration {

    @Value("${spring.redis.single.url}")
    private String redisSingleNodeUrl;

    @Value("${spring.redis.cluster.url}")
    private String redisClusterUrl;

    @Value("${spring.redis.nodes.number}")
    private Integer nodesNumber;

    private static final int DEFAULT_PORT = 6379;
    private static final String ID_TEMPLATE = "{id}";


    @Bean
    public ReactiveRedisTemplate<String, String> reactiveRedisStringTemplate() {
        StringRedisSerializer keySerializer = new StringRedisSerializer();

        RedisSerializationContext.RedisSerializationContextBuilder<String, String> builder =
                RedisSerializationContext.newSerializationContext(keySerializer);

        RedisSerializationContext<String, String> context = builder.value(keySerializer).build();

        return new ReactiveRedisTemplate<>(lettuceConnectionFactory(), context);
    }

    @Bean
    public ReactiveRedisTemplate<String, byte[]> reactiveRedisBytesArrayTemplate() {
        StringRedisSerializer keySerializer = new StringRedisSerializer();

        RedisSerializationContext.RedisSerializationContextBuilder<String, byte[]> builder =
                RedisSerializationContext.newSerializationContext(keySerializer);

        RedisSerializationContext<String, byte[]> context = builder.value(RedisSerializer.byteArray()).build();

        return new ReactiveRedisTemplate<>(lettuceConnectionFactory(), context);
    }


    @Bean
    public ReactiveRedisConnectionFactory lettuceConnectionFactory() {
        if (nodesNumber == 1) {
            log.info("Connecting to a single Redis node with Lettuce and url:{}", redisSingleNodeUrl);

            return new LettuceConnectionFactory(redisSingleNodeUrl, DEFAULT_PORT);
        } else {
            log.info("Connecting to a cluster of Redis nodes with Lettuce, {} nodes and template url:{}", nodesNumber, redisSingleNodeUrl);

            RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
            List<RedisNode> redisNodes = new ArrayList<>(nodesNumber);

            LettuceClientConfiguration clientConfiguration = LettuceClientConfiguration
                    .builder()
                    .readFrom(ReadFrom.REPLICA_PREFERRED)
                    .build();

            Flux.range(0, nodesNumber).doOnNext(nodesNumber -> redisNodes.add(
                    new RedisNode(redisClusterUrl.replace(ID_TEMPLATE, String.valueOf(nodesNumber)), DEFAULT_PORT)))
                    .subscribe();

            redisClusterConfiguration.setClusterNodes(redisNodes);

            return new LettuceConnectionFactory(redisClusterConfiguration, clientConfiguration);
        }
    }
}
