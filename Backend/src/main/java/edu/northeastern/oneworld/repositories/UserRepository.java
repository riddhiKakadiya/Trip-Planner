package edu.northeastern.oneworld.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.oneworld.models.User;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Integer>{

	/**
	 * Method to find user by username
	 * @param p
	 * @return Person
	 */
	@Query("SELECT p FROM Person p WHERE p.username=:username")
	Iterable<User> findUserByUsername(@Param("username") String p);

	/**
	 * Method to find user by credentials
	 * @param username
	 * @param password
	 * @return Person
	 */
	@Query("SELECT p FROM Person p WHERE p.username=:username AND p.password=:password")
	Iterable<User> findUserByCredentials(@Param("username") String username, @Param("password") String password);

	/**
	 * Method to find user by credentials
	 * @param username
	 * @return Person
	 */
	@Query("SELECT p.class FROM Person p WHERE p.username=:username")
	String getUserType(@Param("username") String username);

	/**
	 * Method to find user by username
	 * @param username
	 * @return Person
	 */
	@Query("SELECT p FROM Person p WHERE p.username=:username")
	Iterable<User> getUserByUsername(@Param("username") String username);

	/**
	 * Method to find all users
	 */
	@Query("SELECT p FROM Person p WHERE p.class=User")
	Iterable<User> getUsers();
}
