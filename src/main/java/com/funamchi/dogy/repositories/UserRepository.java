package com.funamchi.dogy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.funamchi.dogy.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query(value = "SELECT * FROM User u WHERE u.nom LIKE %:input% OR u.prenom LIKE %:input%", nativeQuery = true)
	public List<User> searchUser(@Param("input")String input);
	
	@Query(value = "SELECT u FROM User u WHERE u.email = :input")
	public User searchUserByEmail(@Param("input")String input);

}
