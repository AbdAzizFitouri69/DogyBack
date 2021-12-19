package com.funamchi.dogy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funamchi.dogy.entities.Annonce;
import com.funamchi.dogy.entities.AnnonceAccouplement;
import com.funamchi.dogy.entities.AnnonceFound;
import com.funamchi.dogy.entities.AnnonceLost;
import com.funamchi.dogy.entities.AnnonceVente;
import com.funamchi.dogy.services.implementations.AnnonceServiceImplementation;

@RestController
@RequestMapping("/annonces")
public class AnnonceController {
	
	
	@Autowired
	AnnonceServiceImplementation annonceServiceImplementation;
	
	
	@GetMapping("/")
	public List<Annonce> getAnnonces(){
		return annonceServiceImplementation.getAnnonces();
	}
	
	@GetMapping("/accouplement")
	public List<Annonce> getAnnoncesAccouplement(){
		return annonceServiceImplementation.getAnnoncesAccouplements();
	}
	
	@GetMapping("/vente")
	public List<Annonce> getAnnoncesVente(){
		return annonceServiceImplementation.getAnnonceVente();
	}
	
	@GetMapping("/lost")
	public List<Annonce> getAnnoncesLost(){
		return annonceServiceImplementation.getAnnonceLost();
	}
	
	@GetMapping("/found")
	public List<Annonce> getAnnoncesFound(){
		return annonceServiceImplementation.getAnnonceFound();
	}
	
	@GetMapping("/pending")
	public List<Annonce> getPendingAnnonce(){
		return annonceServiceImplementation.getPendingAnnonces();
	}
	
	@GetMapping("/accepted")
	public List<Annonce> getAcceptedAnnonce(){
		return annonceServiceImplementation.getAcceptedAnnonces();
	}
	
	@PostMapping("/accouplement/add/{idUser}")
	public Annonce addAccouplement(@RequestBody AnnonceAccouplement accouplement, @PathVariable("idUser") Long idUser) {
		return annonceServiceImplementation.addAnnonce(accouplement,idUser);
	}
	
	@PostMapping("/vente/add/{idUser}")
	public Annonce addVente(@RequestBody AnnonceVente vente, @PathVariable("idUser")Long idUser) {
		return annonceServiceImplementation.addAnnonce(vente,idUser);
	}
	
	@PostMapping("/lost/add/{idUser}")
	public Annonce addLost(@RequestBody AnnonceLost lost, @PathVariable("idUser")Long idUser) {
		return annonceServiceImplementation.addAnnonce(lost,idUser);
	}
	
	@PostMapping("/found/add/{idUser}")
	public Annonce addFound(@RequestBody AnnonceFound found, @PathVariable("idUser")Long idUser) {
		return annonceServiceImplementation.addAnnonce(found,idUser);
	}
	
	@PutMapping("/accept/{idAnnonce}")
	public Annonce acceptAnnonce(@PathVariable("idAnnonce")Long idAnnonce) {
		return annonceServiceImplementation.acceptAnnonce(idAnnonce);
	}
	
	@PutMapping("/refuse/{idAnnonce}")
	public Annonce refuseAnnonce(@PathVariable("idAnnonce")Long idAnnonce) {
		return annonceServiceImplementation.refuseAnnonce(idAnnonce);
	}
	
	
	
}
