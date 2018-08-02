package edu.northeastern.oneworld.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Destination Representation
 *
 */
@Entity
public class Destination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Owner owner;
	@OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Trip> trips;
	@OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Review> reviews;
	private String placeId;
	private int priceRange;
	private double rating;
	private int phoneNumber;
	private String address;
	private String photoReference;
	private String name;
	private String timings;
	private String websiteLink;
	private double latitude;
	private double longitude;
	private String city;
	private String country;
	private String destinationType;

	public Destination(Owner owner, List<Trip> trips, List<Review> reviews, String placeId, int priceRange, double rating, int phoneNumber, String address, String photoReference, String name, String timings, String websiteLink, double latitude, double longitude, String city, String country, String destinationType) {
		this.owner = owner;
		this.trips = trips;
		this.reviews = reviews;
		this.placeId = placeId;
		this.priceRange = priceRange;
		this.rating = rating;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.photoReference = photoReference;
		this.name = name;
		this.timings = timings;
		this.websiteLink = websiteLink;
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		this.country = country;
		this.destinationType = destinationType;
	}

	public Destination() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPriceRange() {
		return priceRange;
	}

	public void setPriceRange(int priceRange) {
		this.priceRange = priceRange;
	}

	public double getRating() {
		return rating;
	}

	public String getPhotoReference() {
		return photoReference;
	}

	public void setPhotoReference(String photoReference) {
		this.photoReference = photoReference;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

	public String getWebsiteLink() {
		return websiteLink;
	}

	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getDestinationType() {
		return destinationType;
	}

	public void setDestinationType(String destinationType) {
		this.destinationType = destinationType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setDestinationReviews(Review review){
		this.reviews.add(review);
		if(review.getDestination() != this)
			review.setDestination(this);
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
		if(!owner.getDestinations().contains(this))
			owner.getDestinations().add(this);
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Destination{" +
				"id=" + id +
				", owner=" + owner +
				", trips=" + trips +
				", reviews=" + reviews +
				", placeId='" + placeId + '\'' +
				", priceRange=" + priceRange +
				", rating=" + rating +
				", phoneNumber=" + phoneNumber +
				", address='" + address + '\'' +
				", photoReference='" + photoReference + '\'' +
				", name='" + name + '\'' +
				", timings='" + timings + '\'' +
				", websiteLink='" + websiteLink + '\'' +
				", latitude=" + latitude +
				", longitude=" + longitude +
				", city='" + city + '\'' +
				", country='" + country + '\'' +
				", destinationType='" + destinationType + '\'' +
				'}';
	}
}
