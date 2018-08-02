package edu.northeastern.oneworld.repositories;

import edu.northeastern.oneworld.models.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.oneworld.models.User;


public interface AdminRepository extends CrudRepository<Admin, Integer>{

    /**
     * Method to find user by username
     * @param p
     * @return Person
     */
    @Query("SELECT p FROM Person p WHERE p.username=:username")
    Iterable<Admin> findUserByUsername(@Param("username") String p);

    /**
     * Method to find user by credentials
     * @param username
     * @param password
     * @return Person
     */
    @Query("SELECT p FROM Person p WHERE p.username=:username AND p.password=:password")
    Iterable<Admin> findUserByCredentials(@Param("username") String username, @Param("password") String password);

    /**
     * Method to find user by credentials
     * @param username
     * @return Person
     */
    @Query("SELECT p.class FROM Person p WHERE p.username=:username")
    String getUserType(@Param("username") String username);
}
