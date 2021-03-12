package mn.lettuce.tester.repositories;//package mn.redisson.tester.repositories;

import io.lettuce.core.KeyValue;
import io.lettuce.core.Value;
import io.lettuce.core.api.reactive.RedisHashReactiveCommands;
import io.lettuce.core.api.reactive.RedisServerReactiveCommands;
import io.lettuce.core.api.reactive.RedisStringReactiveCommands;
import lombok.extern.slf4j.Slf4j;
import mn.lettuce.tester.entities.Itinerary;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
@Slf4j
public class LettuceRepository {

    @Inject
    private RedisStringReactiveCommands<String, String> stringReactiveCommands;

    @Inject
    private RedisHashReactiveCommands<String, String>  hashReactiveCommands;

    @Inject
    private RedisServerReactiveCommands<String, String>  serverReactiveCommands;

    private final static String DEFAULT_REDIS_HASHMAP_NAME = "TEST_HASHMAP";


    public Mono<String> save(Itinerary itinerary) {
        return stringReactiveCommands.set(itinerary.getHash(), itinerary.getPayload());
    }

    public Mono<String> saveAll(Flux<Itinerary> itineraries) {
        return itineraries
                .collectMap(Itinerary::getHash, Itinerary::getPayload)
                .flatMap(stringReactiveCommands::mset);
    }

    public Mono<Boolean> saveInHashMap(Itinerary itinerary) {
        return hashReactiveCommands.hset(
               DEFAULT_REDIS_HASHMAP_NAME, itinerary.getHash(), itinerary.getPayload());
    }

    public Mono<String> saveAllInHashMap(List<Itinerary> itineraries) {
        return Flux.fromIterable(itineraries)
                .collectMap(Itinerary::getHash, Itinerary::getPayload)
                .flatMap(map -> hashReactiveCommands.hmset(DEFAULT_REDIS_HASHMAP_NAME, map));
    }

    public void saveAllWithPipelining(List<Itinerary> itineraries) {
        /**
         * Lettuce does not await command completion before sending subsequent commands
         * to Redis which means lettuce uses pipelining by default.
         */
    }


    public Mono<String> find(String hash) {
        return stringReactiveCommands.get(hash);
    }

    public Flux<String> findAll(List<String> hashes) {
        return stringReactiveCommands.mget(hashes.toArray(new String[0]))
                .map(stringStringKeyValue -> {
                    if (stringStringKeyValue.hasValue()) {
                        return stringStringKeyValue.getValue();
                    } else {
                        return "";
                    }
                });
    }

    public Mono<String> findInHashmap(String hash) {
        return hashReactiveCommands.hget(DEFAULT_REDIS_HASHMAP_NAME, hash);
    }

    public Flux<String> findAllInHashmap(List<String> hashes) {
        return hashReactiveCommands.hmget(DEFAULT_REDIS_HASHMAP_NAME, hashes.toArray(new String[0]))
                .map(stringStringKeyValue -> {
                    if (stringStringKeyValue.hasValue()) {
                        return stringStringKeyValue.getValue();
                    } else {
                        return "";
                    }
                });
    }

    public Mono<Long> count() {
        return serverReactiveCommands.dbsize();
    }

    public Mono<String> deleteAll() {
        return serverReactiveCommands.flushallAsync();
    }
}
