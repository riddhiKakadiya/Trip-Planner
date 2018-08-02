package edu.northeastern.oneworld.repositories;

import edu.northeastern.oneworld.models.UserLike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLikeRepository extends CrudRepository<UserLike, Integer> {
}
