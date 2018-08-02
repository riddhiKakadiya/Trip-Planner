package edu.northeastern.oneworld.services;

import com.google.gson.Gson;
import edu.northeastern.oneworld.models.Destination;
import edu.northeastern.oneworld.models.Review;
import edu.northeastern.oneworld.models.Trip;
import edu.northeastern.oneworld.models.UserLike;
import edu.northeastern.oneworld.repositories.DestinationRepository;
import edu.northeastern.oneworld.repositories.TripRepository;
import edu.northeastern.oneworld.repositories.UserLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.crypto.Des;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:63342", "http://localhost:63343"})
public class DestinationService {

    @Autowired
    DestinationRepository destinationRepository;

    @Autowired
    TripRepository tripRepository;

    @Autowired
    UserLikeRepository userLikeRepository;

    @PostMapping("/api/destination")
    public Destination saveDestination(@RequestBody String json){
        Gson g = new Gson();
        Destination destination = g.fromJson(json, Destination.class);
        return destinationRepository.save(destination);
    }

    @GetMapping("/api/destination")
    public Iterable<Destination> findAllDestinations(){
        return destinationRepository.findAll();
    }

//    @PostMapping("/api/destination/{dId}/trip/{tripId}")
//    public void addDestinationToTrip(@PathVariable("dId") int dId,
//                                     @PathVariable("tripId") int tripId){
//        Optional<Trip> optionalTrip = tripRepository.findById(tripId);
//        Optional<Destination> optionalDestination = destinationRepository.findById(dId);
//        if (optionalTrip.isPresent() && optionalDestination.isPresent()){
//            Trip t = optionalTrip.get();
//            Destination d = optionalDestination.get();
//            d.addToTrip(t);
//            destinationRepository.save(d);
//        }
//    }

    @GetMapping("/api/destination/{dId}")
    public Optional<Destination> findDestinationById(@PathVariable("dId") int id){
        return destinationRepository.findById(id);
    }

    @GetMapping("/api/destination/{dId}/review")
    public Iterable<Review> getReviewsForDestination(@PathVariable("dId") int id){
        Optional<Destination> optionalDestination = destinationRepository.findById(id);
        if(optionalDestination.isPresent()){
            Destination d = optionalDestination.get();
            return d.getReviews();
        }
        return null;
    }

    @PostMapping("/api/destination/like")
    public UserLike likeDestination(@RequestBody String json){
        Gson g = new Gson();
        UserLike userLike = g.fromJson(json, UserLike.class);
        return userLikeRepository.save(userLike);
    }

    @DeleteMapping("/api/destination/like")
    public void unlikeDestination(@PathVariable("likeId") int id) {
        userLikeRepository.deleteById(id);
    }
}
