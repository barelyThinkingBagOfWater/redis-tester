package mn.redisson.tester.rest;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import mn.redisson.tester.entities.Itinerary;
import mn.redisson.tester.repositories.RedissonRepository;
import org.redisson.api.BatchResult;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.inject.Inject;
import java.util.List;

@Controller
public class ItineraryController {

    @Inject
    private RedissonRepository repository;

    @Post(value = "/itinerary", consumes = MediaType.APPLICATION_JSON)
    public Mono<Void> saveItinerary(@Body Itinerary itinerary) {
        return repository.save(itinerary);
    }

    @Post(value = "/itineraries", consumes = MediaType.APPLICATION_JSON)
    public Mono<Void> saveItineraries(@Body List<Itinerary> itineraries) {
        return repository.saveAll(itineraries);
    }

    @Post(value = "/itineraries/pipeline", consumes = MediaType.APPLICATION_JSON)
    public Mono<BatchResult<?>> saveItinerariesUsingPipeline(@Body List<Itinerary> itineraries) {
        return repository.saveAllWithPipelining(itineraries);
    }

    @Post("/find")
    @Produces(MediaType.APPLICATION_JSON)
    public Mono<String> findItinerary(@Body String hash) {
        return repository.find(hash);
    }

    @Post(value = "/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Flux<String> findItineraries(@Body List<String> hashes) {
        return repository.findAll(hashes);
    }


    //HASHMAP
    @Post(value = "/itinerary/hashmap", consumes = MediaType.APPLICATION_JSON)
    public Mono<Boolean> saveItineraryInHashmap(@Body Itinerary itinerary) {
        return repository.saveInHashMap(itinerary);
    }

    @Post(value = "/itineraries/hashmap", consumes = MediaType.APPLICATION_JSON)
    public Mono<Void> saveItinerariesInHashmap(@Body List<Itinerary> itineraries) {
        return repository.saveAllInHashMap(itineraries);
    }

    @Post(value = "/itineraries/hashmap/pipeline", consumes = MediaType.APPLICATION_JSON)
    public Mono<BatchResult<?>> saveItinerariesInHashmapUsingPipeline(@Body List<Itinerary> itineraries) {
        return repository.saveAllInHashMapWithPipelining(itineraries);
    }

    @Post("/find/hashmap")
    @Produces(MediaType.APPLICATION_JSON)
    public Mono<String> findItineraryInHashmap(@Body String hash) {
        return repository.findInHashmap(hash);
    }

    @Post(value = "/findAll/hashmap")
    @Produces(MediaType.APPLICATION_JSON)
    public Flux<String> findItinerariesInHashmap(@Body List<String> hashes) {
        return repository.findAllInHashmap(hashes);
    }

    //MISC
    @Delete(value = "/itineraries")
    public Mono<Long> deleteAll() {
        return repository.deleteAll();
    }
}
