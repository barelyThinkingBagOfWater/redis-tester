package com.springmvcredissontester.rest;

import com.springmvcredissontester.entities.Itinerary;
import com.springmvcredissontester.repositories.RedissonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ItineraryController {

    @Autowired
    private RedissonRepository repository;

    @PostMapping(value = "/find", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public String findItinerary(@RequestBody String hash) {
        return repository.find(hash);
    }

    @PostMapping(value = "/findAll", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public List<String> findItineraries(@RequestBody List<String> hashes) {
        return repository.findAll(hashes);
    }

    @PostMapping(value = "/itinerary", consumes = APPLICATION_JSON_VALUE)
    public void saveItinerary(@RequestBody Itinerary itinerary) {
        repository.save(itinerary);
    }

    @PostMapping(value = "/itineraries", consumes = APPLICATION_JSON_VALUE)
    public void saveItineraries(@RequestBody List<Itinerary> itineraries) {
        repository.saveAll(itineraries);
    }

    @PostMapping(value = "/itineraries/pipeline", consumes = APPLICATION_JSON_VALUE)
    public void saveItinerariesWithPipeline(@RequestBody List<Itinerary> itineraries) {
        repository.saveAllWithPipelining(itineraries);
    }

    //HASHMAP
    @PostMapping(value = "/find/hashmap", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public String findItineraryInHashmap(@RequestBody String hash) {
        return repository.findInHashmap(hash);
    }

    @PostMapping(value = "/findAll/hashmap", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public List<String> findItinerariesInHashmap(@RequestBody List<String> hashes) {
        return repository.findAllInHashmap(hashes);
    }

    @PostMapping(value = "/itinerary/hashmap", consumes = APPLICATION_JSON_VALUE)
    public void saveItineraryInHashmap(@RequestBody Itinerary itinerary) {
        repository.saveInHashMap(itinerary);
    }

    @PostMapping(value = "/itineraries/hashmap", consumes = APPLICATION_JSON_VALUE)
    public void saveItinerariesInHashmap(@RequestBody List<Itinerary> itineraries) {
        repository.saveAllInHashMap(itineraries);
    }

    @PostMapping(value = "/itineraries/hashmap/pipeline", consumes = APPLICATION_JSON_VALUE)
    public void saveItinerariesInHashmapWithPipeline(@RequestBody List<Itinerary> itineraries) {
        repository.saveAllInHashMapUsingPipelining(itineraries);
    }

    //MISC
    @DeleteMapping(value = "/itineraries")
    public void deleteAll() {
        repository.deleteAll();
    }
}
