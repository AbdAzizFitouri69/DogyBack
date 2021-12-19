package com.funamchi.dogy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.funamchi.dogy.entities.EmailNoir;

@Repository
public interface EmailNoirRepository extends CrudRepository<EmailNoir, Long>{
	
	@Query(value = "SELECT * FROM Email_Noir e WHERE e.email LIKE %:input%", nativeQuery = true)
	public List<EmailNoir> searchEmail(@Param("input")String input);
}
