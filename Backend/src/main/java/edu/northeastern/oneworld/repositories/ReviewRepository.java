package edu.northeastern.oneworld.repositories;

import edu.northeastern.oneworld.models.Destination;
import edu.northeastern.oneworld.models.Owner;
import edu.northeastern.oneworld.models.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
