package edu.northeastern.oneworld.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import sun.security.krb5.internal.crypto.Des;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Owner Representation
 *
 */
@Entity
public class Owner extends Person implements Serializable{

	@OneToMany(mappedBy = "owner")
	@JsonIgnore
	private List<Destination> destinations;
	private static final long serialVersionUID = 1L;

	public Owner() {
		super();
	}

	public Owner(String firstName, String lastName, String phoneNumber, String address, String email, String username, String password, String dob, Boolean isAdmin, List<Destination> destination) {
		super(firstName, lastName, phoneNumber, address, email, username, password, dob);
		this.destinations = destinations;
	}

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

	@Override
	public String toString() {
		return "Owner{" +
				"destination=" + destinations +
				'}';
	}
}
