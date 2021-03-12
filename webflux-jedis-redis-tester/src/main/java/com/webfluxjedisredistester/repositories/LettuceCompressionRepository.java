package com.webfluxjedisredistester.repositories;

import com.webfluxredistester.entities.SnappyCompressionService;
import com.webfluxredistester.entities.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;


@Repository
public class LettuceCompressionRepository {

    private final ReactiveRedisTemplate<String, byte[]> redisTemplate;
    private final ReactiveValueOperations<String, byte[]> reactiveValueOps;
    private final ReactiveHashOperations<String, String, byte[]> reactiveHashOps;

    private final SnappyCompressionService compressionService;
    private final static String DEFAULT_REDIS_HASHMAP_NAME = "TEST_HASHMAP";

    @Autowired
    public LettuceCompressionRepository(ReactiveRedisTemplate<String, byte[]> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.reactiveValueOps = redisTemplate.opsForValue();
        this.compressionService = new SnappyCompressionService();
        this.reactiveHashOps = redisTemplate.opsForHash();
    }
    

    public Mono<Boolean> save(TestEntity TestEntity) {
        return reactiveValueOps.set(TestEntity.getHash(),
                compressionService.compressPayload(TestEntity.getPayload()));
    }

    public Mono<Boolean> saveAll(List<TestEntity> testEntities) {
        Map<String, byte[]> testEntitiesToSave = Flux.fromIterable(testEntities)
                .collectMap(testEntity -> testEntity.getHash(),
                        testEntity -> compressionService.compressPayload(testEntity.getPayload()))
                .block(); //subscribe could be nice or transform as map before?

        return reactiveValueOps.multiSet(testEntitiesToSave);
    }

    public Mono<String> find(String hash) {
        return reactiveValueOps.get(hash).map(String::new);
    }

    public Flux<String> findAll(List<String> hashes) {
        return reactiveValueOps.multiGet(hashes)
                .flatMapMany(Flux::fromIterable)
                .map(String::new);
    }

    public Mono<Boolean> saveInHashMap(TestEntity testEntity) {
        return reactiveHashOps.put(
                DEFAULT_REDIS_HASHMAP_NAME, testEntity.getHash(), testEntity.getPayload().getBytes(StandardCharsets.UTF_8));
    }

    public Mono<Boolean> saveAllInHashMap(List<TestEntity> testEntities) {
        Map<String, byte[]> testEntitiesToSave = Flux.fromIterable(testEntities)
                .collectMap(TestEntity::getHash, testEntity -> testEntity.getPayload().getBytes(StandardCharsets.UTF_8))
                .block(); //subscribe could be nice or transform as map before?

        return reactiveHashOps.putAll(DEFAULT_REDIS_HASHMAP_NAME, testEntitiesToSave);
    }

    public Mono<String> findInHashmap(String hash) {
        return reactiveHashOps.get(DEFAULT_REDIS_HASHMAP_NAME, hash).map(String::new);
    }

    public Flux<String> findAllInHashmap(List<String> hashes) {
        return reactiveHashOps.multiGet(DEFAULT_REDIS_HASHMAP_NAME, hashes)
                .flatMapMany(Flux::fromIterable)
                .map(String::new)//TODO: deserialization problem? Same with findInHashMap I surmise
                // java.lang.ClassCastException: class java.lang.String cannot be cast to class [B (java.lang.String and [B are in module java.base of loader 'bootstrap')
                ;
    }


    public Mono<Long> count() {
        return redisTemplate.scan().count();
    }

    public Mono<Long> deleteAllKeys(String... keys) {
        return redisTemplate.delete(keys);
    }

    public Mono<Long> deleteAll() {
        return redisTemplate.delete(redisTemplate.scan());
    }

    public Flux<Object> getInternalMetrics() {
        return redisTemplate.execute(RedisScript.of("INFO"));
    }
}
