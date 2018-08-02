package edu.northeastern.oneworld.services;

import com.google.gson.Gson;
import edu.northeastern.oneworld.models.Destination;
import edu.northeastern.oneworld.models.Trip;
import edu.northeastern.oneworld.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:63342", "http://localhost:63343"})
public class TripService {

    @Autowired
    TripRepository tripRepository;

    @PostMapping("/api/trip")
    public Trip createTrip(@RequestBody String json){
        Gson g = new Gson();
        Trip trip = g.fromJson(json, Trip.class);
        return tripRepository.save(trip);
    }

    @GetMapping("/api/trip")
    public Iterable<Trip> findAllTrips(){
        return tripRepository.findAll();
    }


    @GetMapping("/api/trip/{tid}")
    public Optional<Trip> findAllTrips(@PathVariable("tid") int id){
        return tripRepository.findById(id);
    }


    @GetMapping("/api/trip/{tripId}/destination")
    public Destination findDestinationsInTrip(@PathVariable("tripId") int id){
        Optional<Trip> optionalTrip = tripRepository.findById(id);
        if (optionalTrip.isPresent()) {
            Trip trip = optionalTrip.get();
            return trip.getDestination();
        }
        return null;
    }

    @PutMapping("/api/trip/{tripId}")
    public Trip updateTrip(@PathVariable("tripId") int id, @RequestBody Trip newTrip) {
        Optional<Trip> optionalTrip= tripRepository.findById(id);
        if (optionalTrip.isPresent()) {
            Trip trip = optionalTrip.get();
			trip.set(newTrip);
            return tripRepository.save(trip);
        } else
            return null;
    }

    @DeleteMapping("/api/trip/{tripId}")
    public void deleteTrip(@PathVariable("tripId") int id) {
        tripRepository.deleteById(id);
    }
}
