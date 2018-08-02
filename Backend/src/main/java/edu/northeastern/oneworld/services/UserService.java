package edu.northeastern.oneworld.services;

import java.util.Optional;

import com.google.gson.Gson;
import edu.northeastern.oneworld.models.*;
import edu.northeastern.oneworld.repositories.UserLikeRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.northeastern.oneworld.repositories.TripRepository;
import edu.northeastern.oneworld.repositories.UserRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:63342", "http://localhost:63343"})
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TripRepository tripRepository;

    @Autowired
    UserLikeRepository userLikeRepository;
    /**
     * Method to create a new user
     *
     * @param json user object
     * @return user
     */
    @PostMapping("/api/user/register")
    public User createUser(@RequestBody String json) {
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        return userRepository.save(user);
    }

    /**
     * Method to create a new user
     *
     * @param json
     * @return int
     */
    @PostMapping("/api/user/login")
    public int loginUser(@RequestBody String json) {
        JSONObject object = new JSONObject(json);
        String username = object.getString("username");
        String password = object.getString("password");
            int type = 0;
            switch (userRepository.getUserType(username)){
                case "Admin":
                    type = 1;
                    break;
                case "User":
                    type = 2;
                    break;
                case "Owner":
                    type = 3;
                    break;
                case "EventManager":
                    type = 4;
                    break;
                default:
                    type = 0;
            }
            return type;
    }
    /**
     * Method to find all users
     * @return
     */
    @GetMapping("/api/user")
    public Iterable<User> findAllUsers(@RequestParam(value = "username",required = false) String username){
        if(username != "" && username != null)
            return userRepository.getUserByUsername(username);
        else
            return userRepository.getUsers();
    }

    /**
     * Find a specific user
     *
     * @param id
     * @return
     */
    @GetMapping("/api/user/{userId}")
    public Optional<User> findUserById(@PathVariable("userId") int id) {
        return userRepository.findById(id);
    }

    /**
     * Find a specific user's reviews
     *
     * @param id
     * @return
     */
    @GetMapping("/api/user/{userId}/review")
    public Iterable<Review> findReviewForUser(@PathVariable("userId") int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            return user.getReviews();
        }
        return null;
    }
    /**
     * @param id
     * @param newuser
     * @return
     */
    @PutMapping("/api/user/{userId}")
    public User updateuser(@PathVariable("userId") int id, @RequestBody User newuser) {
        Optional<User> optionaluser = userRepository.findById(id);
        if (optionaluser.isPresent()) {
            User user = optionaluser.get();
            user.set(newuser);
            return userRepository.save(user);
        } else
            return null;
    }

    /**
     * @param id
     */
    @DeleteMapping("/api/user/{userId}")
    public void deleteUser(@PathVariable("userId") int id) {
        userRepository.deleteById(id);
    }


    @PostMapping("/api/user/review/like")
    public UserLike likeReview(@RequestBody String json){
        Gson g = new Gson();
        UserLike userLike = g.fromJson(json, UserLike.class);
        return userLikeRepository.save(userLike);
    }

    @DeleteMapping("/api/user/review/like/{lId}")
    public void unlikeReview(@PathVariable("lId") int id){
        userLikeRepository.deleteById(id);
    }

    /**
     * Add a User to a trip
     * @param uId User id
     * @param tripId Trip id
     */
    @PostMapping("/api/user/{uId}/trip/{tripId}")
    public void addUserToTrip(@PathVariable("uId") int uId,
                                     @PathVariable("tripId") int tripId){
        Optional<Trip> optionalTrip = tripRepository.findById(tripId);
        Optional<User> optionalUser = userRepository.findById(uId);
        if (optionalTrip.isPresent() && optionalUser.isPresent()){
            Trip t = optionalTrip.get();
            User u = optionalUser.get();
            u.addToTrip(t);
            userRepository.save(u);
        }
    }

    @GetMapping("/api/user/{uId}/trip")
    public Iterable<Trip> getAllTripsForUser(@PathVariable("uId") int id){
        Optional<User> optionalUser = findUserById(id);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            return user.getTrips();
        }else
            return null;
    }
}
