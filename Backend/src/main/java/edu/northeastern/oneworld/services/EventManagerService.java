package edu.northeastern.oneworld.services;

import com.google.gson.Gson;
import edu.northeastern.oneworld.models.EventManager;
import edu.northeastern.oneworld.models.Trip;
import edu.northeastern.oneworld.models.User;
import edu.northeastern.oneworld.repositories.EventManagerRepository;
import edu.northeastern.oneworld.repositories.TripRepository;
import edu.northeastern.oneworld.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:63342", "http://localhost:63343"})
public class EventManagerService {

    @Autowired
    EventManagerRepository eventManagerRepository;

    @Autowired
    TripRepository tripRepository;

    @Autowired
    UserRepository userRepository;

    /**
     * Method to create a new event manager
     *
     * @param json event manager object
     * @return event manager
     */
    @PostMapping("/api/eventmanager")
    public EventManager createEventManager(@RequestBody String json) {
        Gson g = new Gson();
        EventManager eventManager = g.fromJson(json, EventManager.class);
        return eventManagerRepository.save(eventManager);
    }

    /**
     * Method to find an event manager
     *
     * @param id event manager id
     * @return event manager
     */
    @GetMapping("/api/eventmanager/{eId}")
    public Optional<EventManager> findEventManagerById(@PathVariable("eId") int id) {
        return eventManagerRepository.findById(id);
    }

    @GetMapping("/api/eventmanager")
    public Iterable<EventManager> getEventManagers() {
        return eventManagerRepository.getEventManagers();
    }

    /**
     * Method to find an event manager for a trip
     *
     * @param id trip id
     * @return event manager
     */
    @GetMapping("/api/trip/{tid}/eventmanager")
    public EventManager findUserById(@PathVariable("tid") int id) {
        Optional<Trip> optionalTrip = tripRepository.findById(id);
        if (optionalTrip.isPresent()) {
            Trip trip = optionalTrip.get();
            return trip.getEventManager();
        }
        return null;
    }

    /**
     * Method to find an event manager for a trip
     *
     * @param id trip id
     * @return event manager
     */
    @GetMapping("/api/eventmanager/{eid}/trip")
    public Iterable<Trip> findTripsForEventManager(@PathVariable("eid") int id) {
        Optional<EventManager> optionalEventManager = eventManagerRepository.findById(id);
        if (optionalEventManager.isPresent()) {
            EventManager eventManager = optionalEventManager.get();
            return eventManager.getTrips();
        }
        return null;
    }

    /**
     * Method to update an event manager for a trip
     *
     * @param id trip id
     * @return event manager
     */
    @PutMapping("/api/eventmanager/{eId}")
    public EventManager updateEventManager(@PathVariable("eId") int id, @RequestBody EventManager neweventmanager) {
        Optional<EventManager> optionalEventManager = eventManagerRepository.findById(id);
        if (optionalEventManager.isPresent()) {
            EventManager eventManager = optionalEventManager.get();
            return eventManagerRepository.save(eventManager);
        } else
            return null;

    }

    /**
     * Method to delete an event manager for a trip
     *
     * @param id event manager id
     */
    @DeleteMapping("/api/eventmanager/{eId}")
    public void deleteEventManager(@PathVariable("eId") int id) {
        eventManagerRepository.deleteById(id);
    }

    /**
     * Add a User to a trip
     *
     * @param eid Event Manager id
     * @param uId User id
     */
    @PostMapping("/api/eventmanager/{eid}/user/{uid}")
    public void addUserToFollowers(@PathVariable("eid") int eid,
                                   @PathVariable("uid") int uId) {
        Optional<EventManager> optionalEventManager = eventManagerRepository.findById(eid);
        Optional<User> optionalUser = userRepository.findById(uId);
        if (optionalEventManager.isPresent() && optionalUser.isPresent()) {
            EventManager eventManager = optionalEventManager.get();
            User u = optionalUser.get();
            eventManager.addUserToFollowers(u);
            eventManagerRepository.save(eventManager);
        }
    }

    /**
     * Add a User to a trip
     *
     * @param eid Event Manager id
     */
    @GetMapping("/api/eventmanager/{eid}/followers")
    public Iterable<User> getAllFollowers(@PathVariable("eid") int eid) {
        Optional<EventManager> optionalEventManager = eventManagerRepository.findById(eid);
        if (optionalEventManager.isPresent()) {
            EventManager eventManager = optionalEventManager.get();
            return eventManager.getFollowers();
        }else
            return null;
    }
}
