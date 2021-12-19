package com.funamchi.dogy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funamchi.dogy.entities.Dogwalker;
import com.funamchi.dogy.entities.Dresseur;
import com.funamchi.dogy.entities.Personnel;
import com.funamchi.dogy.entities.Veterinaire;
import com.funamchi.dogy.services.implementations.PersonnelServiceImplementation;

@RestController
@RequestMapping("/personnels")
public class PersonnelController {
	
	@Autowired
	PersonnelServiceImplementation personnelServiceImplementation;
	
	@GetMapping("/")
	public List<Personnel> getAllPersonnels(){
		return this.personnelServiceImplementation.getAllPersonels();
	}
	
	@GetMapping("/veterinaires")
	public List<Personnel> getAllVeterinaires(){
		return this.personnelServiceImplementation.getAllVeterinaires();
	}
	
	@GetMapping("/dogwalkers")
	public List<Personnel> getAllDogWalkers(){
		return this.personnelServiceImplementation.getAllDogwalkers();
	}
	
	@GetMapping("/dresseurs")
	public List<Personnel> getAllDresseurs(){
		return this.personnelServiceImplementation.getAllDresseurs();
	}
	
	@PostMapping("/veterinaire/add")
	public Personnel addVeterinaire(@RequestBody Veterinaire vet) {
		return personnelServiceImplementation.addPersonnel(vet);
	}
	
	@PostMapping("/dogwalkers/add")
	public Dogwalker addDogwalker(@RequestBody Dogwalker dw) {
		return (Dogwalker) personnelServiceImplementation.addPersonnel(dw);
	}
	
	@PostMapping("/dresseurs/add")
	public Dresseur addVeterinaire(@RequestBody Dresseur dres) {
		return (Dresseur) personnelServiceImplementation.addPersonnel(dres);
	}
	
	@PutMapping("/veterinaires/update")
	public Veterinaire updateVeterinaire(@RequestBody Veterinaire vet) {
		return (Veterinaire) personnelServiceImplementation.modifierPersonnel(vet);
	}
	
	@PutMapping("/dogwalkers/update")
	public Dogwalker updateDogwalker(@RequestBody Dogwalker dw) {
		return (Dogwalker) personnelServiceImplementation.modifierPersonnel(dw);
	}
	
	@PutMapping("dressuers/update")
	public Dresseur updateDresseur(@RequestBody Dresseur dres) {
		return (Dresseur) personnelServiceImplementation.modifierPersonnel(dres);
	}

}
