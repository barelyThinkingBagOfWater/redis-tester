package com.quarkusredissontester.repositories;//package mn.redisson.tester.repositories;

import com.quarkusredissontester.entities.Itinerary;
import org.redisson.api.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Singleton
public class RedissonRepository {

    @Inject
    RedissonReactiveClient client;

    private final static String DEFAULT_REDIS_HASHMAP_NAME = "TEST_HASHMAP";


    public Mono<Void> save(Itinerary itinerary) {
        RBucketReactive<String> bucket = client.getBucket(itinerary.getHash());
        return bucket.set(itinerary.getPayload());
    }

    public Mono<Void> saveAll(List<Itinerary> itineraries) {
        RBucketsReactive buckets = client.getBuckets();

        return Flux.fromIterable(itineraries)
                .collectMap(Itinerary::getHash, Itinerary::getPayload)
                .flatMap(buckets::set);
    }

    public Mono<BatchResult<?>> saveAllWithPipelining(List<Itinerary> itineraries) {
        RBatchReactive batch = client.createBatch();

        return Flux.fromIterable(itineraries)
                .map(itinerary -> batch.getBucket(itinerary.getHash()).set(itinerary.getPayload()))
                .then(batch.execute());
    }


    public Mono<String> find(String hash) {
        RBucketReactive<String> bucket = client.getBucket(hash);
        return bucket.get();
    }

    public Flux<String> findAll(List<String> hashes) {
        RBucketsReactive buckets = client.getBuckets();

        return buckets.get(hashes.toArray(new String[0]))
                .flatMapIterable(Map::values)
                .cast(String.class);
    }

    public Mono<Boolean> saveInHashMap(Itinerary itinerary) {
        RMapReactive<String, String> map = client.getMap(DEFAULT_REDIS_HASHMAP_NAME);

        return map.fastPut(itinerary.getHash(), itinerary.getPayload());
    }

    public Mono<Void> saveAllInHashMap(List<Itinerary> itineraries) {
        RMapReactive<String, String> map = client.getMap(DEFAULT_REDIS_HASHMAP_NAME);

        return Flux.fromIterable(itineraries)
                .collectMap(Itinerary::getHash, Itinerary::getPayload)
                .flatMap(map::putAll);
    }

    public Mono<BatchResult<?>> saveAllInHashMapWithPipelining(List<Itinerary> itineraries) {
        RBatchReactive batch = client.createBatch();

        return Flux.fromIterable(itineraries)
                .map(itinerary -> batch.getMap(DEFAULT_REDIS_HASHMAP_NAME)
                        .fastPut(itinerary.getHash(), itinerary.getPayload()))
                .then(batch.execute());
    }

    public Mono<String> findInHashmap(String hash) {
        return client.getMap(DEFAULT_REDIS_HASHMAP_NAME).get(hash).cast(String.class);
    }

    public Flux<String> findAllInHashmap(List<String> hashes) {
        RMapReactive<String, String> map = client.getMap(DEFAULT_REDIS_HASHMAP_NAME);
        return map.getAll(new HashSet<>(hashes))
                .flatMapIterable(Map::values);
    }

    public Mono<Long> count() {
        return client.getKeys().count();
    }

    public Flux<String> getKeysInDb() {
        return client.getKeys().getKeys();
    }

        public Mono<Long> deleteAllKeys(String... keys) {
        return client.getKeys().delete(keys);
    }

    public Mono<Long> deleteAll() {
        return client.getKeys().deleteByPattern("*"); //TEST ME
    }
}
