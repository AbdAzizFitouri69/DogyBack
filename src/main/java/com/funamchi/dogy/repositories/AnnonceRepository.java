package com.funamchi.dogy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.funamchi.dogy.entities.Annonce;
import com.funamchi.dogy.entities.AnnonceAccouplement;
import com.funamchi.dogy.entities.AnnonceFound;
import com.funamchi.dogy.entities.AnnonceLost;
import com.funamchi.dogy.entities.AnnonceVente;

@Repository
public interface AnnonceRepository extends CrudRepository<Annonce, Long> {

	// ADVANCED FILTERING SECTION

	@Query(value = "SELECT * FROM Annonce a WHERE a.user_id_user = :input ORDER BY a.id_annonce DESC", nativeQuery = true)
	public List<Annonce> getUserAnnonces(@Param("input") Long input);

	@Query(value = "SELECT * FROM Annonce a WHERE a.status = 'RESOLU' ORDER BY a.id_annonce DESC", nativeQuery = true)
	public List<Annonce> getResolvedAnnonces();

	// FILTER BY ACCEPTED STATUS
	@Query(value = "SELECT * FROM Annonce a WHERE a.status = 'ACCEPTED' ORDER BY a.id_annonce DESC", nativeQuery = true)
	public List<Annonce> getAccepted();

	// GET ACCEPTED VENTE
	@Query(value = "SELECT * FROM Annonce a WHERE a.status = 'ACCEPTED' AND a.type_annonce = 'AnnonceVente' ORDER BY a.id_annonce DESC", nativeQuery = true)
	public List<AnnonceVente> getAcceptedVente();

	// GET ACCEPTED ACCOUPLEMENT
	@Query(value = "SELECT * FROM Annonce a WHERE a.status = 'ACCEPTED' AND a.type_annonce = 'AnnonceAccouplement' ORDER BY a.id_annonce DESC", nativeQuery = true)
	public List<AnnonceAccouplement> getAcceptedAccouplement();

	// GET ACCEPTED FOUND
	@Query(value = "SELECT * FROM Annonce a WHERE a.status = 'ACCEPTED' AND a.type_annonce = 'AnnonceFound' ORDER BY a.id_annonce DESC", nativeQuery = true)
	public List<AnnonceFound> getAcceptedFound();

	// GET ACCEPTED LOST
	@Query(value = "SELECT * FROM Annonce a WHERE a.status = 'ACCEPTED' AND a.type_annonce = 'AnnonceLost' ORDER BY a.id_annonce DESC", nativeQuery = true)
	public List<AnnonceLost> getAcceptedLost();

	// FILTER BY PENDING STATUS
	@Query(value = "SELECT * FROM Annonce a WHERE a.status = 'PENDING' ORDER BY a.id_annonce DESC", nativeQuery = true)
	public List<Annonce> getPending();

	// FILTER BY TITLE IN INPUT
	@Query(value = "SELECT * FROM Annonce a WHERE a.status = 'ACCEPTED' AND a.titre LIKE '%:input%' ORDER BY a.id_annonce DESC", nativeQuery = true)
	public List<Annonce> rechercheAnnonce(@Param("input") String input);

	// FILTER BY CURRENT CITY
	@Query(value = "SELECT * FROM Annonce a WHERE a.status = 'ACCEPTED' AND a.ville = :ville ORDER BY a.id_annonce DESC", nativeQuery = true)
	public List<Annonce> AnnoncesFromVille(@Param("ville") int villeNum);

	// FILTER BY CURRENT CITY VENTE
	@Query(value = "SELECT * FROM Annonce a WHERE a.status = 'ACCEPTED' AND a.type_annonce = 'AnnonceVente' AND a.ville = :ville ORDER BY a.id_annonce DESC", nativeQuery = true)
	public List<AnnonceVente> filterCityVente(@Param("ville") int villeNum);

	// FILTER BY CURRENT CITY ACCOUPLEMENT
	@Query(value = "SELECT * FROM Annonce a WHERE a.status = 'ACCEPTED' AND a.type_annonce = 'AnnonceAccouplement' AND a.ville = :ville ORDER BY a.id_annonce DESC", nativeQuery = true)
	public List<AnnonceAccouplement> filterCityAccouplement(@Param("ville") int villeNum);

	// FILTER BY CURRENT CITY FOUND
	@Query(value = "SELECT * FROM Annonce a WHERE a.status = 'ACCEPTED' AND a.type_annonce = 'AnnonceFound' AND a.ville = :ville ORDER BY a.id_annonce DESC", nativeQuery = true)
	public List<AnnonceFound> filterCityFound(@Param("ville") int villeNum);

	// FILTER BY CURRENT CITY LOST
	@Query(value = "SELECT * FROM Annonce a WHERE a.status = 'ACCEPTED' AND a.type_annonce = 'AnnonceLost' AND a.ville = :ville ORDER BY a.id_annonce DESC", nativeQuery = true)
	public List<AnnonceLost> filterCityLost(@Param("ville") int villeNum);

	// ORDER BY SECTION

	// ORDER BY TITRE
	@Query(value = "SELECT * FROM Annonce a ORDER BY a.titre", nativeQuery = true)
	public List<Annonce> AnnoncesOrdredByTitre();

	// ORDER BY VILLE
	@Query(value = "SELECT * FROM Annonce a ORDER BY a.ville", nativeQuery = true)
	public List<Annonce> AnnoncesOrdredByVille();

	// ORDER BY USER
	@Query(value = "SELECT * FROM Annonce a ORDER BY a.user.nom", nativeQuery = true)
	public List<Annonce> AnnoncesOrdredByUserLastName();

}
