package com.funamchi.dogy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.funamchi.dogy.entities.Commentaire;

@Repository
public interface CommentaireRepository extends CrudRepository<Commentaire, Long>{
	
	@Query(value="SELECT * FROM Commentaire c WHERE c.user.idUser == :idUser", nativeQuery = true)
	public List<Commentaire> getCommentsOfUser(@Param("idUser") Long idUser);

}
