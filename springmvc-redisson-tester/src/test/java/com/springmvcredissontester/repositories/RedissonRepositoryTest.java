package com.springmvcredissontester.repositories;


import com.springmvcredissontester.entities.ItinerariesGenerator;
import com.springmvcredissontester.entities.Itinerary;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
 * Compression cannot really be tested right now  as the generated payload of the TestEntities that are being saved in DB
 * are randomized. Once we have the real entities with some names of cities and such we'll have enough repetitions
 * to actually make use of the compression
 *
 * Do we want to test the load 1 entity methods with maybe some random Ids? To be discussed
 */
class RedissonRepositoryTest {

    @Autowired
    private RedissonRepository repository;
    private final ItinerariesGenerator generator = new ItinerariesGenerator();

    private static final long TESTED_ENTITIES_COUNT = 100;


    @BeforeEach
    public void setUp() {
        repository.deleteAll();

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
        List<Itinerary> itineraries = generator.generateItinaries(TESTED_ENTITIES_COUNT);
        log.info("Testing now method:{}", testInfo.getDisplayName());
        long initTime = System.currentTimeMillis();

        // WHEN
        itineraries.forEach(testEntity -> repository.save(testEntity));

        // THEN
        log.info("time taken:{} ms", System.currentTimeMillis() - initTime);
        assertThat(TESTED_ENTITIES_COUNT == repository.count());
    }

    @Test
    public void saveAll(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> itineraries = generator.generateItinaries(TESTED_ENTITIES_COUNT);
        log.info("Testing now method:{}", testInfo.getDisplayName());
        long initTime = System.currentTimeMillis();

        // WHEN
        repository.saveAll(itineraries);

        // THEN
        log.info("time taken:{} ms", System.currentTimeMillis() - initTime);
        assertThat(TESTED_ENTITIES_COUNT == repository.count());
    }

    @Test
    public void saveAllUsingPipelining(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> itineraries = generator.generateItinaries(TESTED_ENTITIES_COUNT);
        log.info("Testing now method:{}", testInfo.getDisplayName());
        long initTime = System.currentTimeMillis();

        // WHEN
        repository.saveAllWithPipelining(itineraries);

        // THEN
        log.info("time taken:{} ms", System.currentTimeMillis() - initTime);
        assertThat(TESTED_ENTITIES_COUNT == repository.count());
    }

    @Test
    public void saveInHashmap(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> itineraries = generator.generateItinaries(TESTED_ENTITIES_COUNT);
        log.info("Testing now method:{}", testInfo.getDisplayName());
        long initTime = System.currentTimeMillis();

        // WHEN
        itineraries.forEach(testEntity -> repository.saveInHashMap(testEntity));

        // THEN
        log.info("time taken:{} ms", System.currentTimeMillis() - initTime);
        assertThat(TESTED_ENTITIES_COUNT == repository.count());
    }

    @Test
    public void saveAllInHashMap(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> itineraries = generator.generateItinaries(TESTED_ENTITIES_COUNT);
        log.info("Testing now method:{}", testInfo.getDisplayName());
        long initTime = System.currentTimeMillis();

        // WHEN
        repository.saveAllInHashMap(itineraries);

        // THEN
        log.info("time taken:{} ms", System.currentTimeMillis() - initTime);
        assertThat(TESTED_ENTITIES_COUNT == repository.count());
    }

    @Test
    public void saveAllInHashMapUsingPipelining(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> itineraries = generator.generateItinaries(TESTED_ENTITIES_COUNT);
        log.info("Testing now method:{}", testInfo.getDisplayName());
        long initTime = System.currentTimeMillis();

        // WHEN
        repository.saveAllInHashMapUsingPipelining(itineraries);

        // THEN
        log.info("time taken:{} ms", System.currentTimeMillis() - initTime);
        assertThat(TESTED_ENTITIES_COUNT == repository.count());
    }


    @Test
    public void findAll(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> itineraries = generator.generateItinaries(TESTED_ENTITIES_COUNT);
        List<String> hashes = itineraries.stream().map(Itinerary::getHash).collect(Collectors.toList());
        repository.saveAll(itineraries);

        log.info("Testing now method:{}", testInfo.getDisplayName());
        long initTime = System.currentTimeMillis();

        // WHEN
        List<String> results = repository.findAll(hashes);

        // THEN
        log.info("time taken:{} ms", System.currentTimeMillis() - initTime);
        assertThat(Long.valueOf(TESTED_ENTITIES_COUNT) == results.size());
    }


    @Test
    public void findAllInHashMap(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> itineraries = generator.generateItinaries(TESTED_ENTITIES_COUNT);
        List<String> hashes = itineraries.stream().map(Itinerary::getHash).collect(Collectors.toList());
        repository.saveAllInHashMap(itineraries);

        log.info("Testing now method:{}", testInfo.getDisplayName());
        long initTime = System.currentTimeMillis();

        // WHEN
        List<String> results = repository.findAllInHashmap(hashes);

        // THEN
        log.info("time taken:{} ms", System.currentTimeMillis() - initTime);
        assertThat(TESTED_ENTITIES_COUNT == results.size());
    }




    private void logInterestingStats() {
        Properties props = repository.getInternalMetrics();

        Stream.of("used_memory_human", "io_threaded_writes_processed", "total_writes_processed",
                "used_memory_peak_human", "total_reads_processed")
                .forEach(prop -> log.info("{}:{}", prop, props.getProperty(prop)));
    }

    @Test
    public void listAllInternalMetrics() {
        Properties props = repository.getInternalMetrics();
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