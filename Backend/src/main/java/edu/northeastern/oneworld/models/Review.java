package edu.northeastern.oneworld.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;
import java.util.List;


/**
 * Review Representation
 */
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne()
    @JsonIgnore
    private User user;
    private String description;
    private String dateOfReview;
    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<UserLike> numberOfLikes;
    @ManyToOne
    @JsonIgnore
    private Destination destination;


    public Review() {
        super();
    }


    public Review(int id, User user, int rating, String description, String dateOfReview, List<UserLike> numberOfLikes,
                  Destination destination) {
        super();
        this.id = id;
        this.user = user;
        this.description = description;
        this.dateOfReview = dateOfReview;
        this.numberOfLikes = numberOfLikes;
        this.destination = destination;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getDateOfReview() {
        return dateOfReview;
    }


    public void setDateOfReview(String dateOfReview) {
        this.dateOfReview = dateOfReview;
    }


    public List<UserLike> getNumberOfLikes() {
        return numberOfLikes;
    }


    public void setNumberOfLikes(List<UserLike> numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public void setLikeForReviews(UserLike userLike){
        this.numberOfLikes.add(userLike);
        if(userLike.getReview() != this)
            userLike.setReview(this);
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
        if(!destination.getReviews().contains(this))
            destination.getReviews().add(this);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", user=" + user +
                ", description='" + description + '\'' +
                ", dateOfReview=" + dateOfReview +
                ", numberOfLikes=" + numberOfLikes +
                ", destination=" + destination +
                '}';
    }


}
