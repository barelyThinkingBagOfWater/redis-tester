package com.webfluxredissonredistester.repositories;

import com.webfluxredissonredistester.entities.Itinerary;
import org.redisson.api.BatchResult;
import org.redisson.api.RBatchReactive;
import org.redisson.api.RedissonReactiveClient;
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
public class RedissonRepository {

    private final ReactiveRedisTemplate<String, String> redisTemplate;
    private final ReactiveValueOperations<String, String> reactiveValueOps;
    private final ReactiveHashOperations<String, String, String> reactiveHashOps;
    private final RedissonReactiveClient reactiveClient;

    private final static String DEFAULT_REDIS_HASHMAP_NAME = "TEST_HASHMAP";

    @Autowired
    public RedissonRepository(ReactiveRedisTemplate<String,String> redisTemplate, RedissonReactiveClient reactiveClient) {
        this.redisTemplate = redisTemplate;
        this.reactiveValueOps = redisTemplate.opsForValue();
        this.reactiveHashOps = redisTemplate.opsForHash();
        this.reactiveClient = reactiveClient;
    }


    public Mono<Boolean> save(Itinerary itinerary) {
        return reactiveValueOps.set(itinerary.getHash(), itinerary.getPayload());
    }



    public Mono<Boolean> saveAll(Flux<Itinerary> itineraries) {
        return itineraries
                .collectMap(Itinerary::getHash, Itinerary::getPayload)
                .flatMap(reactiveValueOps::multiSet);
    }

    public Mono<BatchResult<?>> saveAllWithPipelining(Flux<Itinerary> itineraries) {
        RBatchReactive batch = reactiveClient.createBatch();

        return itineraries
                .map(itinerary -> batch.getBucket(itinerary.getHash()).set(itinerary.getPayload()))
                .then(batch.execute());
    }

    public Mono<String> find(String hash) {
        return reactiveValueOps.get(hash);
    }

    public Mono<List<String>> findAll(List<String> hashes) {
        return reactiveValueOps.multiGet(hashes);
    }

    public Mono<Boolean> saveInHashMap(Itinerary itinerary) {
        return reactiveHashOps.put(
                DEFAULT_REDIS_HASHMAP_NAME, itinerary.getHash(), itinerary.getPayload());
    }

    public Mono<Boolean> saveAllInHashMap(Flux<Itinerary> itineraries) {
        return itineraries
                .collectMap(Itinerary::getHash, Itinerary::getPayload)
                .flatMap(entities -> reactiveHashOps.putAll(DEFAULT_REDIS_HASHMAP_NAME, entities));
    }

    public Mono<BatchResult<?>> saveAllInHashMapWithPipelining(Flux<Itinerary> itineraries) {
        RBatchReactive batch = reactiveClient.createBatch();

        return itineraries
                .map(itinerary -> batch.getMap(DEFAULT_REDIS_HASHMAP_NAME)
                        .fastPut(itinerary.getHash(), itinerary.getPayload()))
                .then(batch.execute());
    }

    public Mono<String> findInHashmap(String hash) {
        return reactiveHashOps.get(DEFAULT_REDIS_HASHMAP_NAME, hash);
    }

    public Mono<List<String>> findAllInHashmap(List<String> hashes) { //Doesn't work, same code as with Lettuce though
        return reactiveHashOps.multiGet(DEFAULT_REDIS_HASHMAP_NAME, hashes);
    }

    public Mono<Long> count() {
        return reactiveClient.getKeys().count();
    }

    public Mono<Long> deleteAllKeys(String... keys) {
        return redisTemplate.delete(keys);
    }

    public Mono<Long> deleteAll() {
        return redisTemplate.delete(reactiveClient.getKeys().getKeys());
    }

    public Mono<Properties> getInternalMetrics() {
        ReactiveServerCommands redisServerCommands =
                redisTemplate.getConnectionFactory().getReactiveConnection().serverCommands();
        return redisServerCommands.info();
    }
}
