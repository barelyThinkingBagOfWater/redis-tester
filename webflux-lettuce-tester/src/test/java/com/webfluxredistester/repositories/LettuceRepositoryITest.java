package com.webfluxredistester.repositories;

import com.webfluxredistester.entities.ItinerariesGenerator;
import com.webfluxredistester.entities.Itinerary;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
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

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = {
        "redis.codec=NONE"
})
/**
 * For now the repositories connect to a redis instance on localhost so you need to start one using docker, simply run :
 * docker run --rm -d --name redis -p 6379:6379 redis:6
 *
 * Compression cannot really be tested right now  as the generated payload of the itineraries that are being saved in DB
 * are randomized. Once we have the real entities with some names of cities and such we'll have enough repetitions
 * to actually make use of the compression
 *
 * Do we want to test the load 1 entity methods with maybe some random Ids? To be discussed
 */
class LettuceRepositoryITest {

    @Autowired
    private LettuceRepository repository;
    private final ItinerariesGenerator generator = new ItinerariesGenerator();

    private static final int TESTED_ENTITIES_COUNT = 10000;


    @BeforeEach
    public void setUp() {
        repository.deleteAll().block();
    }

    @Test
    public void saveAll(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> itineraries = generator.generateItinaries(TESTED_ENTITIES_COUNT);

        // WHEN
        trackTimeUsedByCommand(
                repository.saveAll(itineraries),
                testInfo);

        // THEN
        assertThat(TESTED_ENTITIES_COUNT == repository.count().block());
    }

    @Test
    public void save(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> itineraries = generator.generateItinaries(TESTED_ENTITIES_COUNT);

        // WHEN
        trackTimeUsedByCommand(
                Flux.fromIterable(itineraries)
                        .flatMap(entity -> repository.save(entity)),
                testInfo);

        // THEN
        assertThat(TESTED_ENTITIES_COUNT == repository.count().block());
    }

    @Test
    public void find(TestInfo testInfo) {
        // GIVEN
        Itinerary itinerary = generator.generateItinaries(1).get(0);
        repository.save(itinerary).block();

        // WHEN
        String result = repository.find(itinerary.getHash()).block();
        // THEN
        assertThat(itinerary.getPayload().equals(result));
    }

    @Test
    public void findAll(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> itineraries = generator.generateItinaries(TESTED_ENTITIES_COUNT);
        List<String> hashes = Flux.fromIterable(itineraries).map(Itinerary::getHash).collectList().block();
        repository.saveAll(itineraries).block();

        // WHEN
        Mono returnedList = trackTimeUsedByCommandWithReturn(repository.findAll(hashes), testInfo);
        ArrayList entities = (ArrayList) returnedList.block();

        // THEN
        assertThat(Long.valueOf(TESTED_ENTITIES_COUNT) == entities.size());
    }


    @Test
    public void findAllInHashMap(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> itineraries = generator.generateItinaries(TESTED_ENTITIES_COUNT);
        List<String> hashes = Flux.fromIterable(itineraries).map(Itinerary::getHash).collectList().block();
        repository.saveAllInHashMap(Flux.fromIterable(itineraries)).block();


        // WHEN
        Mono returnedList = trackTimeUsedByCommandWithReturn(repository.findAllInHashmap(hashes), testInfo);
        ArrayList entities = (ArrayList) returnedList.block();

        // THEN
        assertThat(Long.valueOf(TESTED_ENTITIES_COUNT) == entities.size());
    }

    @Test
    public void saveInHashmap(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> itineraries = generator.generateItinaries(TESTED_ENTITIES_COUNT);

        // WHEN
        trackTimeUsedByCommand(
                Flux.fromIterable(itineraries)
                        .flatMap(entity -> repository.saveInHashMap(entity)),
                testInfo);

        // THEN
        assertThat(TESTED_ENTITIES_COUNT == repository.count().block());
    }

    @Test
    public void saveAllInHashMap(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> itineraries = generator.generateItinaries(TESTED_ENTITIES_COUNT);

        // WHEN
        trackTimeUsedByCommand(
                repository.saveAllInHashMap(Flux.fromIterable(itineraries)),
                testInfo);

        // THEN
        assertThat(TESTED_ENTITIES_COUNT == repository.count().block());
    }


    private void trackTimeUsedByCommand(Mono mono, TestInfo testInfo) {
        AtomicLong initTime = new AtomicLong();

        mono
                .doOnSubscribe(end -> {
                    log.info("");
                    log.info("Testing now method:{}", testInfo.getDisplayName());
                    initTime.set(System.currentTimeMillis());
                })
                .doFinally(end -> log.info("time taken:{} ms", System.currentTimeMillis() - initTime.get()))
                .block();
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
                })
                .blockLast();
    }


    private void logInterestingStats() {
        Properties props = repository.getInternalMetrics().block();

        Flux.just("used_memory_human", "io_threaded_writes_processed", "total_writes_processed",
                "used_memory_peak_human", "total_reads_processed")

                .doOnNext(prop -> log.info("{}:{}", prop, props.getProperty(prop)))
                .blockLast();
    }

//    @Test
    public void listAllInternalMetrics() {
        Properties props = repository.getInternalMetrics().block();
        props.keySet()
                .stream().sorted()
                .forEach(key -> log.info("Key:{}", key));
    }


    /**
     * Interesting metrics?
     * io_threaded_reads_processed
     * io_threaded_writes_processed
     *
     * keyspace_hits
     * keyspace_misses
     *
     * total_commands_processed
     * total_connections_received
     *
     * total_reads_processed
     * total_writes_processed
     *
     * used_memory_human
     * used_memory_peak_human
     * used_memory_rss_human
     * used_memory_startup
     */
}