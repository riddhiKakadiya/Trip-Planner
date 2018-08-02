package edu.northeastern.oneworld.repositories;

import edu.northeastern.oneworld.models.Destination;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DestinationRepository extends CrudRepository<Destination, Integer> {

    @Query("SELECT d FROM Destination d WHERE d.placeId=:placeId")
    Optional<Destination> findDestinationByPlaceId(@Param("placeId") String placeId);

    /**
     * Method to search Destination by name
     * @param name
     * @return Destination
     */
    @Query("SELECT d FROM Destination d WHERE d.name=:name")
    Optional<Destination> findDestinationByName(@Param("name") String name);

    /**
     * Method to search Destinations by rating
     * @param rating
     * @return List<Destination>
     */
    @Query("SELECT d FROM Destination d WHERE d.rating>=:rating")
    List<Destination> findDestinationByRating(@Param("rating") int rating);
}
