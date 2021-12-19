package com.funamchi.dogy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.funamchi.dogy.entities.Annonce;

@Repository
public interface AnnonceRepository extends CrudRepository<Annonce, Long>{
	
	//ADVANCED FILTERING SECTION
	
	//FILTER BY ACCEPTED STATUS
	@Query(value = "SELECT * FROM Annonce a WHERE a.statut == 'ACCEPTED'", nativeQuery = true)
	public List<Annonce> getAccepted();
	
	
	//FILTER BY PENDING STATUS
	@Query(value = "SELECT * FROM Annonce a WHERE a.statut == 'PENDING'", nativeQuery = true)
	public List<Annonce> getPending();
	
	
	//FILTER BY TITLE IN INPUT
	@Query(value = "SELECT * FROM Annonce a WHERE a.titre LIKE '%:input%'", nativeQuery = true)
	public List<Annonce> rechercheAnnonce(@Param("input")String input);
	
	
	//FILTER BY CURRENT CITY
	@Query(value="SELECT * FROM Annonce a WHERE a.ville == ':ville'", nativeQuery = true)
	public List<Annonce> AnnoncesFromVille(@Param("ville")String ville);

	
	
	//ORDER BY SECTION
	
	//ORDER BY TITRE
	@Query(value = "SELECT * FROM Annonce a ORDER BY a.titre" , nativeQuery = true)
	public List<Annonce> AnnoncesOrdredByTitre();
	
	
	//ORDER BY VILLE
	@Query(value = "SELECT * FROM Annonce a ORDER BY a.ville" , nativeQuery = true)
	public List<Annonce> AnnoncesOrdredByVille();
	
	
	//ORDER BY USER
	@Query(value = "SELECT * FROM Annonce a ORDER BY a.user.nom", nativeQuery = true)
	public List<Annonce> AnnoncesOrdredByUserLastName();
	
}
