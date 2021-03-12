package com.webfluxredistester.repositories;

import com.webfluxredistester.entities.Itinerary;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReactiveServerCommands;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Properties;


@Repository
@Slf4j
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


    public Mono<Boolean> save(Itinerary itinerary) {
        return reactiveValueOps.set(itinerary.getHash(), itinerary.getPayload());
    }

    public void saveAllWithPipelining(Itinerary itinerary) {
        /**
         * Lettuce does not await command completion before sending subsequent commands
         * to Redis which means lettuce uses pipelining by default.
         */
      }

    public Mono<Boolean> saveAll(List<Itinerary> itineraries) {

        log.info("Now saveAll {} entities", itineraries.size());

        return Flux.fromIterable(itineraries)
                .collectMap(Itinerary::getHash, Itinerary::getPayload)
                .flatMap(reactiveValueOps::multiSet);
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

    public Mono<Boolean> saveAllInHashMap(Flux<Itinerary> itinaries) {
        return itinaries
                .collectMap(Itinerary::getHash, Itinerary::getPayload)
                .flatMap(entities -> reactiveHashOps.putAll(DEFAULT_REDIS_HASHMAP_NAME, entities));
    }

    public Mono<String> findInHashmap(String hash) {
        return reactiveHashOps.get(DEFAULT_REDIS_HASHMAP_NAME, hash);
    }

    public Mono<List<String>> findAllInHashmap(List<String> hashes) {
        return reactiveHashOps.multiGet(DEFAULT_REDIS_HASHMAP_NAME, hashes);
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
