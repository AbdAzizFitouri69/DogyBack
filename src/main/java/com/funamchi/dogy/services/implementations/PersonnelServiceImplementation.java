package com.funamchi.dogy.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funamchi.dogy.entities.Dogsitter;
import com.funamchi.dogy.entities.Dogwalker;
import com.funamchi.dogy.entities.Dresseur;
import com.funamchi.dogy.entities.Personnel;
import com.funamchi.dogy.entities.Rating;
import com.funamchi.dogy.entities.Veterinaire;
import com.funamchi.dogy.repositories.PersonnelRepository;
import com.funamchi.dogy.repositories.RatingRepository;
import com.funamchi.dogy.services.PersonnelService;

@Service
public class PersonnelServiceImplementation implements PersonnelService{
	
	@Autowired
	PersonnelRepository personnelRepository;
	
	@Autowired
	RatingRepository ratingRepository;

	@Override
	public List<Personnel> getAllPersonels() {
		return (List<Personnel>) personnelRepository.findAll();
	}

	@Override
	public List<Personnel> getAllVeterinaires() {
		List<Personnel> vets = new ArrayList<>();
		for(Personnel personnel : personnelRepository.findAll()) {
			if(personnel.getClass().getName() == "com.funamchi.dogy.entities.Veterinaire") {
				vets.add(personnel);
			}
		}
		return vets;
	}

	@Override
	public List<Personnel> getAllDogwalkers() {
		List<Personnel> dws = new ArrayList<>();
		for(Personnel personnel : personnelRepository.findAll()) {
			if(personnel.getClass().getName() == "com.funamchi.dogy.entities.Dogwalker") {
				dws.add(personnel);
			}
		}
		return dws;
	}
	
	public List<Personnel> getAllDogsitters(){
		List<Personnel> ds = new ArrayList<>();
		for(Personnel personnel : personnelRepository.findAll()) {
			if(personnel.getClass().getName() == "com.funamchi.dogy.entities.Dogsitter") {
				ds.add(personnel);
			}
		}
		return ds;
	}

	@Override
	public List<Personnel> getAllDresseurs() {
		List<Personnel> dress = new ArrayList<>();
		for(Personnel personnel : personnelRepository.findAll()) {
			if(personnel.getClass().getName() == "com.funamchi.dogy.entities.Dresseur") {
				dress.add(personnel);
			}
		}
		return dress;
	}
	
	
	@Override
	public Personnel addPersonnel(Personnel pers) {
		return this.personnelRepository.save(pers);
	}

	

	@Override
	public Personnel modifierPersonnel(Personnel p) {
		Personnel pers = this.personnelRepository.findById(p.getId()).get();
		pers.setAge(p.getAge());
		pers.setDateNaissance(p.getDateNaissance());
		pers.setDescription(p.getDescription());
		pers.setEmail(p.getEmail());
		pers.setImage(p.getImage());
		pers.setNom(p.getNom());
		pers.setPrenom(p.getPrenom());
		pers.setSexe(p.getSexe());
		pers.setVille(p.getVille());
		return personnelRepository.save(pers);
	}

	@Override
	public void supprimerPersonnel(Long id) {
		personnelRepository.deleteById(id);
	}
	
	public List<Personnel> searchDresseur(String pref) {
		List<Personnel> dress = new ArrayList<>();
		for(Personnel personnel : personnelRepository.search(pref)) {
			if(personnel.getClass().getName() == "com.funamchi.dogy.entities.Dresseur") {
				dress.add(personnel);
			}
		}
		return dress;
	}
	
	public List<Personnel> searchDresseurRegion(String pref) {
		List<Personnel> dress = new ArrayList<>();
		for(Personnel personnel : personnelRepository.getPersonnelByCity(pref)) {
			if(personnel.getClass().getName() == "com.funamchi.dogy.entities.Dresseur") {
				dress.add(personnel);
			}
		}
		return dress;
	}
	
	
	public List<Personnel> searchDogwalker(String pref) {
		List<Personnel> dws = new ArrayList<>();
		for(Personnel personnel : personnelRepository.search(pref)) {
			if(personnel.getClass().getName() == "com.funamchi.dogy.entities.Dogwalker") {
				dws.add(personnel);
			}
		}
		return dws;
	}
	
	public List<Personnel> searchDogwalkerRegion(String pref) {
		List<Personnel> dws = new ArrayList<>();
		for(Personnel personnel : personnelRepository.getPersonnelByCity(pref)) {
			if(personnel.getClass().getName() == "com.funamchi.dogy.entities.Dogwalker") {
				dws.add(personnel);
			}
		}
		return dws;
	}
	
	public List<Personnel> searchDogsitter(String pref) {
		List<Personnel> dws = new ArrayList<>();
		for(Personnel personnel : personnelRepository.search(pref)) {
			if(personnel.getClass().getName() == "com.funamchi.dogy.entities.Dogsitter") {
				dws.add(personnel);
			}
		}
		return dws;
	}
	
	public List<Personnel> searchDogsitterRegion(String pref) {
		List<Personnel> dws = new ArrayList<>();
		for(Personnel personnel : personnelRepository.getPersonnelByCity(pref)) {
			if(personnel.getClass().getName() == "com.funamchi.dogy.entities.Dogsitter") {
				dws.add(personnel);
			}
		}
		return dws;
	}
	
	public List<Personnel> searchVeterinaire(String pref) {
		return personnelRepository.lookForVeterinaire(pref);
//		List<Personnel> vets = new ArrayList<>();
//		for(Personnel personnel : personnelRepository.search(pref)) {
//			if(personnel.getClass().getName() == "com.fumanchi.dogy.entities.Veterinaire") {
//				vets.add(personnel);
//			}
//		}
//		return vets;
	}
	
	public List<Personnel> searchVeterinaireRegion(String pref) {
		List<Personnel> vets = new ArrayList<>();
		for(Personnel personnel : personnelRepository.getPersonnelByCity(pref)) {
			if(personnel.getClass().getName() == "com.funamchi.dogy.entities.Veterinaire") {
				vets.add(personnel);
			}
		}
		return vets;
	}
	
	public List<Rating> getDogWalkerFiableRating(Long idDogwalker){
		Dogwalker dw =  (Dogwalker) personnelRepository.findById(idDogwalker).get();
		List<Rating> ratings = new ArrayList<Rating>();
		for (Rating rating : dw.getRatings()) {
			if(rating.isFiable()) {
				ratings.add(rating);
			}
		}
		return ratings;
	}
	
	public List<Rating> getDogsitterFiableRating(Long idDogsitter){
		Dogsitter dw =  (Dogsitter) personnelRepository.findById(idDogsitter).get();
		List<Rating> ratings = new ArrayList<Rating>();
		for (Rating rating : dw.getRatings()) {
			if(rating.isFiable()) {
				ratings.add(rating);
			}
		}
		return ratings;
	}
	
	public int getNumberFiableDogwalker(Long idDogwalker) {
		return ratingRepository.getFiableNumber(idDogwalker);
	}
	
	public int getNumberFiableDogsitter(Long idDogsitter) {
		return ratingRepository.getFiableNumberDogsitter(idDogsitter);
	}
	
	public List<Rating> getDogWalkerNonFiableRating(Long idDogwalker){
		Dogwalker dw =  (Dogwalker) personnelRepository.findById(idDogwalker).get();
		List<Rating> ratings = new ArrayList<Rating>();
		for (Rating rating : dw.getRatings()) {
			if(rating.isNon_fiable()) {
				ratings.add(rating);
			}
		}
		return ratings;
	}
	
	public List<Rating> getDogsitterNonFiableRating(Long idDogsitter){
		Dogsitter dw =  (Dogsitter) personnelRepository.findById(idDogsitter).get();
		List<Rating> ratings = new ArrayList<Rating>();
		for (Rating rating : dw.getRatings()) {
			if(rating.isNon_fiable()) {
				ratings.add(rating);
			}
		}
		return ratings;
	}
	
	public List<Rating> getUserRatingForDogwalker(Long idUser, Long idDogwalker){
		return ratingRepository.getUserRatingToDogWalker(idUser, idDogwalker);
	}
	
	public List<Rating> getUserRatingForDogsitter(Long idUser, Long idDogsitter){
		return ratingRepository.getUserRatingToDogsitter(idUser, idDogsitter);
	}

	

}
