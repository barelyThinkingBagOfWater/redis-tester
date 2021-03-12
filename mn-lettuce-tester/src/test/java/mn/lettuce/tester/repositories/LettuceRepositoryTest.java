package mn.lettuce.tester.repositories;


import io.lettuce.core.KeyValue;
import io.lettuce.core.Value;
import io.micronaut.context.annotation.Property;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import lombok.extern.slf4j.Slf4j;
import mn.lettuce.tester.entities.ItinerariesGenerator;
import mn.lettuce.tester.entities.Itinerary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


/**
 * For now the repositories connect to a redis instance on localhost so you need to start one using docker, simply run :
 * docker run --rm -d --name redis -p 6379:6379 redis:6
 *
 * Compression cannot really be tested right now  as the generated payload of the TestEntities that are being saved in DB
 * are randomized. Once we have the real entities with some names of cities and such we'll have enough repetitions
 * to actually make use of the compression
 **/
@Slf4j
@MicronautTest
@Property(name = "redis.codec", value = "SNAPPY")
class LettuceRepositoryTest {

    @Inject
    private LettuceRepository repository;

    private final ItinerariesGenerator generator = new ItinerariesGenerator();

    private static final Long TESTED_ENTITIES_COUNT = 1000L;


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
                repository.saveAll(Flux.fromIterable(itineraries)),
                testInfo);

        // THEN
        Assertions.assertEquals(TESTED_ENTITIES_COUNT, repository.count().block());
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
        Assertions.assertEquals(TESTED_ENTITIES_COUNT, repository.count().block());
    }

    @Test
    public void find(TestInfo testInfo) {
        // GIVEN
        Itinerary entity = generator.generateItinaries(1L).get(0);
        String hash = entity.getHash();
        repository.save(entity).block();

        // WHEN
        String payload = repository.find(hash).block();

        // THEN
        Assertions.assertEquals(entity.getPayload(), payload);
    }

    @Test
    public void findAll(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> itineraries = generator.generateItinaries(TESTED_ENTITIES_COUNT);
        List<String> hashes = Flux.fromIterable(itineraries).map(Itinerary::getHash).collectList().block();
        repository.saveAll(Flux.fromIterable(itineraries)).block();

        // WHEN
        List<String> results = trackTimeUsedByCommandWithReturn(repository.findAll(hashes), testInfo)
                .collectList().block();


        // THEN
        Assertions.assertEquals(TESTED_ENTITIES_COUNT, results.size());
    }


    @Test
    public void findAllInHashMap(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> itineraries = generator.generateItinaries(TESTED_ENTITIES_COUNT);
        List<String> hashes = Flux.fromIterable(itineraries).map(Itinerary::getHash).collectList().block();
        repository.saveAllInHashMap(itineraries).block();

        // WHEN
        List<String> results = trackTimeUsedByCommandWithReturn(repository.findAllInHashmap(hashes), testInfo)
                .collectList().block();

        // THEN
        Assertions.assertEquals(TESTED_ENTITIES_COUNT, results.size());
    }

    @Test
    public void saveInHashmap(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> itineraries = generator.generateItinaries(TESTED_ENTITIES_COUNT);

        List<String> hashes = Flux.fromIterable(itineraries)
                .map(Itinerary::getHash)
                .collectList().block();

        // WHEN
        trackTimeUsedByCommand(
                Flux.fromIterable(itineraries)
                        .flatMap(entity -> repository.saveInHashMap(entity)),
                testInfo);

        // THEN
        Assertions.assertEquals(TESTED_ENTITIES_COUNT,
                repository.findAllInHashmap(hashes).collectList().block().size());
    }

    @Test
    public void saveAllInHashMap(TestInfo testInfo) {
        // GIVEN
        List<Itinerary> itineraries = generator.generateItinaries(TESTED_ENTITIES_COUNT);

        List<String> hashes = Flux.fromIterable(itineraries)
                .map(Itinerary::getHash)
                .collectList().block();

        // WHEN
        trackTimeUsedByCommand(
                repository.saveAllInHashMap(itineraries),
                testInfo);

        // THEN
        Assertions.assertEquals(TESTED_ENTITIES_COUNT,
                repository.findAllInHashmap(hashes).collectList().block().size());
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

    private  Flux<String> trackTimeUsedByCommandWithReturn(Flux<String> flux,
                                                                             TestInfo testInfo) {
        AtomicLong initTime = new AtomicLong();

        return flux
                .doOnSubscribe(end -> {
                    log.info("");
                    log.info("Testing now method:{}", testInfo.getDisplayName());
                    initTime.set(System.currentTimeMillis());
                })
                .doFinally(end -> {
                    log.info("time taken:{} ms", System.currentTimeMillis() - initTime.get());
                });
    }
}