package edu.northeastern.oneworld.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.oneworld.models.Trip;

public interface TripRepository extends CrudRepository<Trip, Integer>{

}
