package com.funamchi.dogy.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funamchi.dogy.entities.Dogwalker;
import com.funamchi.dogy.entities.Dresseur;
import com.funamchi.dogy.entities.Personnel;
import com.funamchi.dogy.entities.Veterinaire;
import com.funamchi.dogy.repositories.PersonnelRepository;
import com.funamchi.dogy.services.PersonnelService;

@Service
public class PersonnelServiceImplementation implements PersonnelService{
	
	@Autowired
	PersonnelRepository personnelRepository;

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
	
	public List<Personnel> searchVeterinaire(String pref) {
		List<Personnel> vets = new ArrayList<>();
		for(Personnel personnel : personnelRepository.search(pref)) {
			if(personnel.getClass().getName() == "com.fumanchi.dogy.entities.Veterinaire") {
				vets.add(personnel);
			}
		}
		return vets;
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

	

}
