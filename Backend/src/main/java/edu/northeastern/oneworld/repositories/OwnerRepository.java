package edu.northeastern.oneworld.repositories;

import edu.northeastern.oneworld.models.EventManager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.oneworld.models.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Integer>{

	/**
	 * Method to find user by username
	 * @param u
	 * @return Person
	 */
	@Query("SELECT u FROM Person u WHERE u.username=:username")
	Iterable<Owner> findUserByUsername(@Param("username") String u);

	/**
	 * Method to find user by credentials
	 * @param username
	 * @param password
	 * @return Person
	 */
	@Query("SELECT u FROM Person u WHERE u.username=:username AND u.password=:password")
	Iterable<Owner> findUserByCredentials(@Param("username") String username, @Param("password") String password);

	/**
	 * Method to find all owners
	 */
	@Query("SELECT p FROM Person p WHERE p.class=Owner")
	Iterable<Owner> getOwners();
}
