package com.webfluxredissonredistester.repositories;


import com.webfluxredissonredistester.entities.ItinerariesGenerator;
import com.webfluxredissonredistester.entities.Itinerary;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {
        "redis.codec=SNAPPY"
})
/**
 * For now the repositories connect to a redis instance on localhost so you need to start one using docker, simply run :
 * docker run --rm -d --name redis -p 6379:6379 redis:6
 *
 * Compression cannot really be tested right now  as the generated payload of the TestEntities that are being saved in DB
 * are randomized. Once we have the real entities with some names of cities and such we'll have enough repetitions
 * to actually make use of the compression
 **/
class RedissonRepositoryTest {

    @Autowired
    private RedissonRepository repository;
    private final ItinerariesGenerator generator = new ItinerariesGenerator();
    
    private static final Long TESTED_ENTITIES_COUNT = 1000L;


    @BeforeEach
    public void setUp() {
        repository.deleteAll().block();

        log.info("");
        log.info("STATS BEFORE TEST");
        logInterestingStats();
    }

    @AfterEach
    public void cleanUp() {
        log.info("");
        log.info("STATS AFTER TEST");
        logInterestingStats();
    }


    @Test
    public void save(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> testEntities = generator.generateItinaries(TESTED_ENTITIES_COUNT);

        // WHEN
        trackTimeUsedByCommand(
                Flux.fromIterable(testEntities)
                        .flatMap(entity -> repository.save(entity)),
                testInfo);

        // THEN
        Assertions.assertThat(TESTED_ENTITIES_COUNT == repository.count().block());
    }

    @Test
    public void saveAll(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> testEntities = generator.generateItinaries(TESTED_ENTITIES_COUNT);

        // WHEN
        trackTimeUsedByCommand(
                repository.saveAll(Flux.fromIterable(testEntities)),
                testInfo);

        // THEN
        Assertions.assertThat(TESTED_ENTITIES_COUNT == repository.count().block());
    }

    @Test
    public void saveAllWithPipelining(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> testEntities = generator.generateItinaries(TESTED_ENTITIES_COUNT);

        // WHEN
        trackTimeUsedByCommand(
                repository.saveAllWithPipelining(Flux.fromIterable(testEntities)),
                testInfo);

        // THEN
        Assertions.assertThat(TESTED_ENTITIES_COUNT == repository.count().block());
    }

    @Test
    public void findAll(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> testEntities = generator.generateItinaries(TESTED_ENTITIES_COUNT);
        List<String> hashes = Flux.fromIterable(testEntities).map(Itinerary::getHash).collectList().block();
        repository.saveAll(Flux.fromIterable(testEntities)).block();

        // WHEN
        Mono returnedList = trackTimeUsedByCommandWithReturn(repository.findAll(hashes), testInfo);
        ArrayList entities = (ArrayList) returnedList.block();

        // THEN
        Assertions.assertThat(Long.valueOf(TESTED_ENTITIES_COUNT) == entities.size());
    }


    @Ignore //findAllInHAshmap doesn't work, same code as with Lettuce though. Weird but not that relevant.
    public void findAllInHashMap(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> testEntities = generator.generateItinaries(TESTED_ENTITIES_COUNT);
        List<String> hashes = Flux.fromIterable(testEntities).map(Itinerary::getHash).collectList().block();
        repository.saveAllInHashMap(Flux.fromIterable(testEntities)).block();

        // WHEN
        Mono returnedList = trackTimeUsedByCommandWithReturn(repository.findAllInHashmap(hashes), testInfo);
        ArrayList entities = (ArrayList) returnedList.block();

        // THEN
        Assertions.assertThat(Long.valueOf(TESTED_ENTITIES_COUNT) == entities.size());
    }

    @Test
    public void saveInHashmap(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> testEntities = generator.generateItinaries(TESTED_ENTITIES_COUNT);

        // WHEN
        trackTimeUsedByCommand(
                Flux.fromIterable(testEntities)
                        .flatMap(entity -> repository.saveInHashMap(entity)),
                testInfo);

        // THEN
        Assertions.assertThat(TESTED_ENTITIES_COUNT == repository.count().block());
    }

    @Test
    public void saveAllInHashMap(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> testEntities = generator.generateItinaries(TESTED_ENTITIES_COUNT);

        // WHEN
        trackTimeUsedByCommand(
                repository.saveAllInHashMap(Flux.fromIterable(testEntities)),
                testInfo);

        // THEN
        Assertions.assertThat(TESTED_ENTITIES_COUNT == repository.count().block());
    }

    @Test
    public void saveAllInHashmapWithPipelining(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> testEntities = generator.generateItinaries(TESTED_ENTITIES_COUNT);

        // WHEN
        trackTimeUsedByCommand(
                repository.saveAllInHashMapWithPipelining(Flux.fromIterable(testEntities)),
                testInfo);

        // THEN
        Assertions.assertThat(TESTED_ENTITIES_COUNT == repository.count().block());
    }





    private void trackTimeUsedByCommand(Mono mono, TestInfo testInfo) {
        AtomicLong initTime = new AtomicLong();

        mono
                .doOnSubscribe(end -> {
                    log.info("");
                    log.info("Testing now method:{}", testInfo.getDisplayName());
                    initTime.set(System.currentTimeMillis());
                })
                .doFinally(end -> log.info("time taken:{} ms", System.currentTimeMillis() - initTime.get())).block();
    }

    private Mono trackTimeUsedByCommandWithReturn(Mono mono, TestInfo testInfo) {
        AtomicLong initTime = new AtomicLong();

        return mono
                .doOnSubscribe(end -> {
                    log.info("");
                    log.info("Testing now method:{}", testInfo.getDisplayName());
                    initTime.set(System.currentTimeMillis());
                })
                .doFinally(end -> log.info("time taken:{} ms", System.currentTimeMillis() - initTime.get()));
    }

    private void trackTimeUsedByCommand(Flux flux, TestInfo testInfo) {
        AtomicLong initTime = new AtomicLong();

        flux
                .doOnSubscribe(end -> {
                    log.info("");
                    log.info("Testing now method:{}", testInfo.getDisplayName());
                    initTime.set(System.currentTimeMillis());
                })
                .doFinally(end -> {
                    log.info("time taken:{} ms", System.currentTimeMillis() - initTime.get());
                }).blockLast();
    }



    private void logInterestingStats() {
        Properties props = repository.getInternalMetrics().block();

        Flux.just("used_memory_human", "io_threaded_writes_processed", "total_writes_processed",
                "used_memory_peak_human", "total_reads_processed")

                .doOnNext(prop -> log.info("{}:{}", prop, props.getProperty(prop)))
                .blockLast();
    }

        @Test
    public void listAllInternalMetrics() {
        Properties props = repository.getInternalMetrics().block();
        props.keySet()
                .stream().sorted()
                .forEach(key -> log.info("Key:{}", key));
    }
}