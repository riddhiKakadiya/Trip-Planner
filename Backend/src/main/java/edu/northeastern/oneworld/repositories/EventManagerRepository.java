package edu.northeastern.oneworld.repositories;

import edu.northeastern.oneworld.models.EventManager;
import edu.northeastern.oneworld.models.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EventManagerRepository extends CrudRepository<EventManager, Integer> {

    /**
     * Method to find user by credentials
     */
    @Query("SELECT p FROM Person p WHERE p.class=EventManager")
    Iterable<EventManager> getEventManagers();
}
