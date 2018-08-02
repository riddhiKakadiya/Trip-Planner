package edu.northeastern.oneworld.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Trip representation
 */
@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany(mappedBy = "trips", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<User> users;
    @ManyToOne
    @JsonIgnore
    private EventManager eventManager;
    @ManyToOne
    @JsonIgnore
    private Destination destination;

    public Trip() {
        super();
    }

    public Trip(String name, List<User> users, EventManager eventManager, String date, Destination destination) {
        this.users = users;
        this.eventManager = eventManager;
        this.destination = destination;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getUser() {
        return users;
    }

    public void setUser(List<User> user) {
        this.users = user;
    }


    public EventManager getEventManager() {
        return eventManager;
    }

    public void setEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
        if(!eventManager.getTrips().contains(this))
            eventManager.getTrips().add(this);
    }


    public void set(Trip newTrip) {
        this.setDestination(newTrip.getDestination() != null ? newTrip.getDestination() : this.getDestination());
        this.setUser(newTrip.getUser() != null ? newTrip.getUser() : this.getUser());
        this.setEventManager(newTrip.getEventManager() != null ? newTrip.getEventManager() : this.getEventManager());
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", user=" + users +
                ", eventManager=" + eventManager +
                ", destinations=" + destination +
                '}';
    }
}
