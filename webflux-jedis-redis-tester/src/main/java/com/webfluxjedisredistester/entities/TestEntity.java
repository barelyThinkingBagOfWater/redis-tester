package com.webfluxjedisredistester.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
@ToString
@AllArgsConstructor
@Getter
/**
 * Test entity to persist during our tests
 *
 */
public class TestEntity {
    @Id
    private final String hash; //The hash will be calculated outside of the entity in real code

    private final String payload;
}
