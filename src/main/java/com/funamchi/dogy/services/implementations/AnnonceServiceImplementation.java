package com.funamchi.dogy.services.implementations;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funamchi.dogy.entities.Annonce;
import com.funamchi.dogy.entities.AnnonceAccouplement;
import com.funamchi.dogy.entities.AnnonceFound;
import com.funamchi.dogy.entities.AnnonceLost;
import com.funamchi.dogy.entities.AnnonceVente;
import com.funamchi.dogy.entities.User;
import com.funamchi.dogy.entities.Ville;
import com.funamchi.dogy.repositories.AnnonceRepository;
import com.funamchi.dogy.repositories.UserRepository;
import com.funamchi.dogy.services.AnnonceService;

@Service
public class AnnonceServiceImplementation implements AnnonceService{

	@Autowired
	AnnonceRepository annonceRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<Annonce> getAnnonces() {
		return (List<Annonce>) annonceRepository.findAll();
	}

	@Override
	public Annonce addAnnonce(Annonce annonce, Long idUser) {
		annonce.setStatus("PENDING");
		annonce.setCreatedAt(new Date(Calendar.getInstance().getTime().getTime()));
		User user = userRepository.findById(idUser).get();
		annonce.setUser(user);
		return annonceRepository.save(annonce);
	}
	

	@Override
	public Annonce updateAnnonce(Annonce annonce) {
		Annonce toBeUpdated = annonceRepository.findById(annonce.getIdAnnonce()).get();
		toBeUpdated.setAge(annonce.getAge());
		toBeUpdated.setDescription(annonce.getDescription());
		toBeUpdated.setVille(annonce.getVille());
		toBeUpdated.setTitre(annonce.getTitre());
		toBeUpdated.setRace(annonce.getRace());
		toBeUpdated.setSexe(annonce.getSexe());
		toBeUpdated.setTaille(annonce.getTaille());
		toBeUpdated.setStatus("PENDING");
		return annonceRepository.save(toBeUpdated);
	}

	@Override
	public Annonce acceptAnnonce(Long id) {
		Annonce annonce = annonceRepository.findById(id).get();
		annonce.setStatus("ACCEPTED");
		return annonceRepository.save(annonce);
	}

	@Override
	public Annonce refuseAnnonce(Long id) {
		Annonce annonce = annonceRepository.findById(id).get();
		annonce.setStatus("REFUSED");
		return annonceRepository.save(annonce);
	}
	
	public Annonce resolveAnnonce(Long id) {
		Annonce annonce = annonceRepository.findById(id).get();
		annonce.setStatus("RESOLU");
		return annonceRepository.save(annonce);
	}
	
	public List<Annonce> getUserAnnonce(Long id){
		return annonceRepository.getUserAnnonces(id);
	}

	@Override
	public List<Annonce> getAcceptedAnnonces() {
		return annonceRepository.getAccepted();
	}
	
	public List<Annonce> getAcceptedAnnoncesCity(String city){
		int villeNum = Ville.valueOf(city).ordinal();
		return annonceRepository.AnnoncesFromVille(villeNum);
	}

	@Override
	public List<Annonce> getPendingAnnonces() {
		return annonceRepository.getPending();
	}
	
	public List<Annonce> getResolvedAnnonces(){
		return annonceRepository.getResolvedAnnonces();
	}
	
	public List<AnnonceVente> getAcceptedVente(){
		return annonceRepository.getAcceptedVente();
	}
	
	public List<AnnonceAccouplement> getAcceptedAccouplement(){
		return annonceRepository.getAcceptedAccouplement();
	}
	
	public List<AnnonceFound> getAcceptedFound(){
		return annonceRepository.getAcceptedFound();
	}
	
	public List<AnnonceLost> getAcceptedLost(){
		return annonceRepository.getAcceptedLost();
	}
	
	public List<AnnonceVente> getCurrentCityVente(String city){
		int villeNum = Ville.valueOf(city).ordinal();
		return annonceRepository.filterCityVente(villeNum);
	}
	
	public List<AnnonceAccouplement> getCurrentCityAccouplement(String city){
		int villeNum = Ville.valueOf(city).ordinal();
		return annonceRepository.filterCityAccouplement(villeNum);
	}
	
	public List<AnnonceLost> getCurrentCityLost(String city){
		int villeNum = Ville.valueOf(city).ordinal();
		return annonceRepository.filterCityLost(villeNum);
	}
	
	public List<AnnonceFound> getCurrentCityFound(String city){
		int villeNum = Ville.valueOf(city).ordinal();
		return annonceRepository.filterCityFound(villeNum);
	}

	

	@Override
	public List<Annonce> getAnnoncesAccouplements() {
		List<Annonce> lst = new ArrayList<>();
		for(Annonce annonce : annonceRepository.findAll()) {
			if(annonce.getClass().getName() == "com.funamchi.dogy.entities.AnnonceAccouplement") {
				lst.add(annonce);
			}
		}
		return lst;
	}

	@Override
	public List<Annonce> getAnnonceVente() {
		List<Annonce> lst = new ArrayList<>();
		for(Annonce annonce : annonceRepository.findAll()) {
			if(annonce.getClass().getName() == "com.funamchi.dogy.entities.AnnonceVente") {
				lst.add(annonce);
			}
		}
		return lst;
	}

	@Override
	public List<Annonce> getAnnonceLost() {
		List<Annonce> lst = new ArrayList<>();
		for(Annonce annonce : annonceRepository.findAll()) {
			if(annonce.getClass().getName() == "com.funamchi.dogy.entities.AnnonceLost") {
				lst.add(annonce);
			}
		}
		return lst;
	}

	@Override
	public List<Annonce> getAnnonceFound() {
		List<Annonce> lst = new ArrayList<>();
		for(Annonce annonce : annonceRepository.findAll()) {
			if(annonce.getClass().getName() == "com.funamchi.dogy.entities.AnnonceFound") {
				lst.add(annonce);
			}
		}
		return lst;
	}

	
	
	
	
}
