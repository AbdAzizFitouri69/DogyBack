package com.funamchi.dogy.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.funamchi.dogy.entities.Dogwalker;
import com.funamchi.dogy.entities.Dresseur;
import com.funamchi.dogy.entities.ImageModel;
import com.funamchi.dogy.entities.Personnel;
import com.funamchi.dogy.entities.Veterinaire;
import com.funamchi.dogy.entities.Ville;
import com.funamchi.dogy.repositories.ImageModelRepository;
import com.funamchi.dogy.services.implementations.PersonnelServiceImplementation;

@RestController
@RequestMapping("/personnels")
public class PersonnelController {
	
	@Autowired
	PersonnelServiceImplementation personnelServiceImplementation;
	
	@Autowired
	ImageModelRepository imageModelRepository;
	
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
	public Personnel addVeterinaire(
			@RequestParam("nom") String nom ,
			@RequestParam("prenom") String prenom ,
			@RequestParam("dateNaissance") String dateNaissance ,
			@RequestParam("sexe") String sexe ,
			@RequestParam("email") String email ,
			@RequestParam("horraire") String horraire ,
			@RequestParam("ville") String ville,
			@RequestParam("image") MultipartFile file) throws IOException {
		Veterinaire vet = new Veterinaire();
		vet.setNom(nom);
		vet.setPrenom(prenom);
		//vet.setDateNaissance(Date.valueOf(dateNaissance));
		vet.setSexe(sexe);
		vet.setEmail(email);
		vet.setVille(Ville.valueOf(ville));
		vet.setHorraire(horraire);
		ImageModel imageModel = new ImageModel();
		imageModel.setContent(file.getBytes());
		ImageModel savedImageModel = this.imageModelRepository.save(imageModel);
		vet.setImage(savedImageModel);
		return personnelServiceImplementation.addPersonnel(vet);
	}
	
	@PostMapping("/dogwalkers/add")
	public Personnel addDogwalker(
			@RequestParam("nom") String nom ,
			@RequestParam("prenom") String prenom ,
			@RequestParam("dateNaissance") String dateNaissance ,
			@RequestParam("sexe") String sexe ,
			@RequestParam("email") String email ,
			@RequestParam("ville") String ville,
			@RequestParam("image") MultipartFile file) throws IOException {
		Dogwalker dw = new Dogwalker();
		dw.setNom(nom);
		dw.setPrenom(prenom);
		//vet.setDateNaissance(Date.valueOf(dateNaissance));
		dw.setSexe(sexe);
		dw.setEmail(email);
		dw.setVille(Ville.valueOf(ville));
		ImageModel imageModel = new ImageModel();
		imageModel.setContent(file.getBytes());
		ImageModel savedImageModel = this.imageModelRepository.save(imageModel);
		dw.setImage(savedImageModel);
		return personnelServiceImplementation.addPersonnel(dw);
	}
	
	@GetMapping("/dogwalkers/{pref}")
	public List<Personnel> getSearchedDogwalkers(@PathVariable("pref") String pref){
		return personnelServiceImplementation.searchDogwalker(pref);
	}
	
	@GetMapping("/dogwalkers/region/{pref}")
	public List<Personnel> getRegionDogwalker(@PathVariable("pref") String pref){
		return personnelServiceImplementation.searchDogwalkerRegion(pref);
	}
	
	@PostMapping("/dresseurs/add")
	public Personnel addDresseur(
			@RequestParam("nom") String nom ,
			@RequestParam("prenom") String prenom ,
			@RequestParam("dateNaissance") String dateNaissance ,
			@RequestParam("sexe") String sexe ,
			@RequestParam("email") String email ,
			@RequestParam("ville") String ville,
			@RequestParam("image") MultipartFile file) throws IOException {
		Dresseur dr = new Dresseur();
		dr.setNom(nom);
		dr.setPrenom(prenom);
		//vet.setDateNaissance(Date.valueOf(dateNaissance));
		dr.setSexe(sexe);
		dr.setEmail(email);
		dr.setVille(Ville.valueOf(ville));
		ImageModel imageModel = new ImageModel();
		imageModel.setContent(file.getBytes());
		ImageModel savedImageModel = this.imageModelRepository.save(imageModel);
		dr.setImage(savedImageModel);
		return personnelServiceImplementation.addPersonnel(dr);
	}
	
	@GetMapping("/dresseurs/{pref}")
	public List<Personnel> getSearchedDresseur(@PathVariable("pref") String pref){
		return personnelServiceImplementation.searchDresseur(pref);
	}
	
	@GetMapping("/dresseurs/region/{pref}")
	public List<Personnel> getRegionDresseur(@PathVariable("pref") String pref){
		return personnelServiceImplementation.searchDresseurRegion(pref);
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
