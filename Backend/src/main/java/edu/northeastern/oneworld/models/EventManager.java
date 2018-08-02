package edu.northeastern.oneworld.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class EventManager extends Person implements Serializable{

    @OneToMany(mappedBy = "eventManager", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Trip> trips;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "EventManagerFollowers")
    @JsonIgnore
    private List<User> followers;
    private static final long serialVersionUID = 1L;

    public EventManager() {
        super();
    }
    public EventManager(List<Trip> trips) {
        super();
        this.trips = trips;
    }

    public EventManager(String firstName, String lastName, String phoneNumber, String address, String email, String username, String password, String dob, List<Trip> trips, List<User> followers) {
        super(firstName, lastName, phoneNumber, address, email, username, password, dob);
        this.trips = trips;
        this.followers = followers;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public void addUserToFollowers(User user){
        this.followers.add(user);
        if(! user.getEventManagers().contains(this))
            user.getEventManagers().add(this);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "EventManager{" +
                "trips=" + trips +
                '}';
    }
}
