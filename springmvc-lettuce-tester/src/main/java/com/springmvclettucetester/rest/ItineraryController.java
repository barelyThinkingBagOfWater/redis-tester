package com.springmvclettucetester.rest;

import com.springmvclettucetester.entities.Itinerary;
import com.springmvclettucetester.repositories.LettuceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ItineraryController {

    @Autowired
    private LettuceRepository repository;

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

    //HASHMAP
    @PostMapping(value = "/find/hashmap", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findItineraryInHashmap(@RequestBody String hash) {
        return repository.findInHashmap(hash);
    }

    @PostMapping(value = "/findAll/hashmap", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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

    //MISC
    @DeleteMapping(value = "/itineraries")
    public void deleteAll() {
        repository.deleteAll();
    }
}
