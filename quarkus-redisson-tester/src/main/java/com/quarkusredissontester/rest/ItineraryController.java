package com.quarkusredissontester.rest;

import com.quarkusredissontester.entities.Itinerary;
import com.quarkusredissontester.repositories.RedissonRepository;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.converters.multi.MultiReactorConverters;
import io.smallrye.mutiny.converters.uni.UniReactorConverters;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Slf4j
public class ItineraryController {

    @Inject
    private RedissonRepository repository;

    @Path("/itinerary")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveItinerary(Itinerary itinerary) {
        repository.save(itinerary).subscribe();
    }

    @Path("/itineraries")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveItineraries(List<Itinerary> itineraries) {
        repository.saveAll(itineraries).subscribe();
    }

    @Path("/itineraries/pipeline")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveItinerariesUsingPipeline(List<Itinerary> itineraries) {
        repository.saveAllWithPipelining(itineraries).subscribe();
    }

    @Path("/find")
    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<String> findItinerary(String hash) {
        return getUniFromMono(repository.find(hash));
    }

    @Path("/findAll")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Multi<String> findItineraries(List<String> hashes) {
        return getMultiFromFlux(repository.findAll(hashes));
    }

    //HASHMAP
    @Path("/itinerary/hashmap")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveItineraryInHashmap(Itinerary itinerary) {
        repository.saveInHashMap(itinerary).subscribe();
    }

    @Path("/itineraries/hashmap")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveItinerariesInHashmap(List<Itinerary> itineraries) {
        repository.saveAllInHashMap(itineraries).subscribe();
    }

    @Path("/itineraries/hashmap/pipeline")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveItinerariesInHashmapUsingPipeline(List<Itinerary> itineraries) {
        repository.saveAllInHashMapWithPipelining(itineraries).subscribe();
    }


    @POST
    @Path("/find/hashmap")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<String> findItineraryInHashmap(String hash) {
        return getUniFromMono(repository.findInHashmap(hash));
    }

    @Path("/findAll/hashmap")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Multi<String> findItinerariesInHashmap(List<String> hashes) {
        return getMultiFromFlux(repository.findAllInHashmap(hashes));
    }


    //MISC
    @Path("/itineraries")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public void deleteAll() {
        repository.deleteAll().subscribe();
    }

    private Uni<String> getUniFromMono(Mono<String> mono) {
        return Uni.createFrom().converter(UniReactorConverters.fromMono(), mono);
    }

    private Multi<String> getMultiFromFlux(Flux<String> flux) {
        return Multi.createFrom().converter(MultiReactorConverters.fromFlux(), flux);
    }
}
