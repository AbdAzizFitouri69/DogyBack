package com.funamchi.dogy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.funamchi.dogy.entities.Personnel;

@Repository
public interface PersonnelRepository extends CrudRepository<Personnel, Long>{
	
	@Query(value = "SELECT * FROM Personnel p WHERE p.ville = :ville", nativeQuery = true)
	public List<Personnel> getPersonnelByCity(@Param("ville")String ville);
	
	@Query(value = "SELECT * FROM Personnel p WHERE p.sexe = :sexe", nativeQuery = true)
	public List<Personnel> getPersonnelByGender(@Param("sexe")String sexe);
	
	@Query(value = "SELECT * FROM Personnel p WHERE p.nom LIKE %:pref% OR p.prenom LIKE %:pref%" , nativeQuery = true)
	public List<Personnel> search(@Param("pref")String pref);

}
