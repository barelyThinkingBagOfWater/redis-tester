package com.springmvcredissontester.repositories;

import com.springmvcredissontester.entities.Itinerary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisServerCommands;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;


@Repository
public class RedissonRepository {

    private final RedisTemplate<String, String> redisTemplate;
    private final ValueOperations<String, String> valueOps;
    private final HashOperations<String, String, String> hashOps;
    private final RedisServerCommands redisServerCommands;

    private final static String DEFAULT_REDIS_HASHMAP_NAME = "TEST_HASHMAP";

    @Autowired
    public RedissonRepository(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.valueOps = redisTemplate.opsForValue();
        this.hashOps = redisTemplate.opsForHash();
        this.redisServerCommands = redisTemplate.getConnectionFactory().getConnection().serverCommands();
    }


    public void save(Itinerary itinerary) {
        valueOps.set(itinerary.getHash(), itinerary.getPayload());
    }

    public void saveAll(List<Itinerary> itineraries) {
        Map<String, String> entities = itineraries.stream()
                .collect(Collectors.toMap(Itinerary::getHash, Itinerary::getPayload));

        valueOps.multiSet(entities);
    }

    public void saveAllWithPipelining(List<Itinerary> itineraries) {
        redisTemplate.executePipelined((RedisCallback<Object>) connection -> {
            itineraries.forEach(itinerary ->
                    redisTemplate.opsForValue().set(itinerary.getHash(), itinerary.getPayload()));
            return null;
        });
    }

    public String find(String hash) {
        return valueOps.get(hash);
    }

    public List<String> findAll(List<String> hashes) {
        return valueOps.multiGet(hashes);
    }

    public void saveInHashMap(Itinerary itinerary) {
        hashOps.put(DEFAULT_REDIS_HASHMAP_NAME, itinerary.getHash(), itinerary.getPayload());
    }

    public void saveAllInHashMap(List<Itinerary> itineraries) {
        Map<String, String> entities = itineraries.stream()
                .collect(Collectors.toMap(Itinerary::getHash, Itinerary::getPayload));

        hashOps.putAll(DEFAULT_REDIS_HASHMAP_NAME, entities);
    }

    public void saveAllInHashMapUsingPipelining(List<Itinerary> itineraries) {
        redisTemplate.executePipelined((RedisCallback<Object>) connection -> {
            itineraries.forEach(itinerary ->
                    redisTemplate.opsForHash().put(DEFAULT_REDIS_HASHMAP_NAME,
                            itinerary.getHash(), itinerary.getPayload()));
            return null;
        });
    }

    public String findInHashmap(String hash) {
        return hashOps.get(DEFAULT_REDIS_HASHMAP_NAME, hash);
    }

    public List<String> findAllInHashmap(List<String> hashes) {
        return hashOps.multiGet(DEFAULT_REDIS_HASHMAP_NAME, hashes);
    }

    public Long count() {
        return redisServerCommands.dbSize();
    }

    public Long deleteAllKeys(List<String> keys) {
        return redisTemplate.delete(keys);
    }

    public void deleteAll() {
        redisServerCommands.flushAll();
    }

    public Properties getInternalMetrics() {
        return redisServerCommands.info();
    }
}
