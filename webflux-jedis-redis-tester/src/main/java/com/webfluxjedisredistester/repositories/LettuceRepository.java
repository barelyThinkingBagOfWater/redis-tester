package com.webfluxjedisredistester.repositories;

import com.webfluxredistester.entities.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReactiveServerCommands;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Properties;


@Repository
public class LettuceRepository {

    private final ReactiveRedisTemplate<String, String> redisTemplate;
    private final ReactiveValueOperations<String, String> reactiveValueOps;
    private final ReactiveHashOperations<String, String, String> reactiveHashOps;

    private final static String DEFAULT_REDIS_HASHMAP_NAME = "TEST_HASHMAP";

    @Autowired
    public LettuceRepository(ReactiveRedisTemplate<String,String> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.reactiveValueOps = redisTemplate.opsForValue();
        this.reactiveHashOps = redisTemplate.opsForHash();
    }


    public Mono<Boolean> save(TestEntity TestEntity) {
        return reactiveValueOps.set(TestEntity.getHash(), TestEntity.getPayload());
    }

    public void saveAllWithPipelining(TestEntity TestEntity) {
        //TODO: no pipelining with reactive Lettuce apparently, same as I noticed.
        // Let's see with other libraries how it pans out:
        // https://stackoverflow.com/questions/51866418/pipeline-redis-commands-with-reactive-lettuce
    }

    public Mono<Boolean> saveAll(List<TestEntity> testEntities) {
        Map<String, String> testEntitiesToSave = Flux.fromIterable(testEntities)
                .collectMap(TestEntity::getHash, TestEntity::getPayload)
                .block(); //subscribe could be nice or transform as map before?

        return reactiveValueOps.multiSet(testEntitiesToSave);
    }

    public Mono<String> find(String hash) {
        return reactiveValueOps.get(hash);
    }

    public Flux<String> findAll(List<String> hashes) {
        return reactiveValueOps.multiGet(hashes)
                .flatMapMany(Flux::fromIterable);
    }

    public Mono<Boolean> saveInHashMap(TestEntity testEntity) {
        return reactiveHashOps.put(
                DEFAULT_REDIS_HASHMAP_NAME, testEntity.getHash(), testEntity.getPayload());
    }

    public Mono<Boolean> saveAllInHashMap(List<TestEntity> testEntities) {
        Map<String, String> testEntitiesToSave = Flux.fromIterable(testEntities)
                .collectMap(TestEntity::getHash, TestEntity::getPayload)
                .block(); //subscribe could be nice or transform as map before?

        return reactiveHashOps.putAll(DEFAULT_REDIS_HASHMAP_NAME, testEntitiesToSave);
    }

    public Mono<String> findInHashmap(String hash) {
        return reactiveHashOps.get(DEFAULT_REDIS_HASHMAP_NAME, hash);
    }

    public Flux<String> findAllInHashmap(List<String> hashes) {
        return reactiveHashOps.multiGet(DEFAULT_REDIS_HASHMAP_NAME, hashes)
                .flatMapMany(Flux::fromIterable);
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

    public Mono<Properties> getInternalMetrics() {
        ReactiveServerCommands redisServerCommands =
                redisTemplate.getConnectionFactory().getReactiveConnection().serverCommands();
        return redisServerCommands.info();
    }
}
