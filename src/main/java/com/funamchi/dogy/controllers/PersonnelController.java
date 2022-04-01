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

import com.funamchi.dogy.entities.Dogsitter;
import com.funamchi.dogy.entities.Dogwalker;
import com.funamchi.dogy.entities.Dresseur;
import com.funamchi.dogy.entities.ImageModel;
import com.funamchi.dogy.entities.Personnel;
import com.funamchi.dogy.entities.Rating;
import com.funamchi.dogy.entities.Veterinaire;
import com.funamchi.dogy.entities.Ville;
import com.funamchi.dogy.repositories.ImageModelRepository;
import com.funamchi.dogy.repositories.PersonnelRepository;
import com.funamchi.dogy.services.implementations.PersonnelServiceImplementation;
import com.funamchi.dogy.services.implementations.RatingServiceImplementation;

@RestController
@RequestMapping("/personnels")
public class PersonnelController {
	
	@Autowired
	PersonnelServiceImplementation personnelServiceImplementation;
	
	@Autowired
	ImageModelRepository imageModelRepository;
	
	@Autowired
	PersonnelRepository personnelRepository;
	
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
	
	@GetMapping("/dogsitters")
	public List<Personnel> getAllDogsitters(){
		return this.personnelServiceImplementation.getAllDogsitters();
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
	
	@PostMapping("/dogsitters/add")
	public Personnel addDogsitter(
			@RequestParam("nom") String nom ,
			@RequestParam("prenom") String prenom ,
			@RequestParam("dateNaissance") String dateNaissance ,
			@RequestParam("sexe") String sexe ,
			@RequestParam("email") String email ,
			@RequestParam("ville") String ville,
			@RequestParam("image") MultipartFile file) throws IOException {
		Dogsitter dw = new Dogsitter();
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
	
	@GetMapping("/dogsitters/{pref}")
	public List<Personnel> getSearchedDogsitters(@PathVariable("pref") String pref){
		return personnelServiceImplementation.searchDogsitter(pref);
	}
	
	
	@GetMapping("/dogwalkers/region/{pref}")
	public List<Personnel> getRegionDogwalker(@PathVariable("pref") String pref){
		return personnelServiceImplementation.searchDogwalkerRegion(pref);
	}
	
	@GetMapping("/dogsitters/region/{pref}")
	public List<Personnel> getRegionDogsitter(@PathVariable("pref") String pref){
		return personnelServiceImplementation.searchDogsitterRegion(pref);
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
	
	@GetMapping("/veterinaires/{pref}")
	public List<Personnel> getSearchVeterinaire(@PathVariable("pref") String pref){
		return personnelServiceImplementation.searchVeterinaire(pref);
	}
	
	@GetMapping("/veterinaires/region/{pref}")
	public List<Personnel> getRegionVeterinaire(@PathVariable("pref") String pref){
		return personnelServiceImplementation.searchVeterinaireRegion(pref);
	}
	
	@GetMapping("/dresseurs/region/{pref}")
	public List<Personnel> getRegionDresseur(@PathVariable("pref") String pref){
		return personnelServiceImplementation.searchDresseurRegion(pref);
	}
	
	@PutMapping("/veterinaires/update")
	public Veterinaire updateVeterinaire(
			@RequestParam("id") Long id ,
			@RequestParam("nom") String nom ,
			@RequestParam("prenom") String prenom ,
			@RequestParam("dateNaissance") String dateNaissance ,
			@RequestParam("sexe") String sexe ,
			@RequestParam("email") String email ,
			@RequestParam("ville") String ville,
			@RequestParam("description") String description,
			@RequestParam("horraire") String horaire
			//@RequestParam("image") MultipartFile file
			) {
		Veterinaire vet = (Veterinaire) this.personnelRepository.findById(id).get();
		vet.setNom(nom);
		vet.setPrenom(prenom);
		vet.setDateNaissance(Date.valueOf(dateNaissance));
		vet.setSexe(sexe);
		vet.setEmail(email);
		vet.setVille(Ville.valueOf(ville));
		vet.setDescription(description);
		vet.setHorraire(horaire);
		return (Veterinaire) personnelServiceImplementation.modifierPersonnel(vet);
	}
	
	@PutMapping("/dogwalkers/update")
	public Dogwalker updateDogwalker(
			@RequestParam("id") Long id ,
			@RequestParam("nom") String nom ,
			@RequestParam("prenom") String prenom ,
			@RequestParam("dateNaissance") String dateNaissance ,
			@RequestParam("sexe") String sexe ,
			@RequestParam("email") String email ,
			@RequestParam("ville") String ville,
			@RequestParam("description") String description
			//@RequestParam("image") MultipartFile file
			) throws IOException {
		Dogwalker dw = (Dogwalker) this.personnelRepository.findById(id).get();
		dw.setNom(nom);
		dw.setPrenom(prenom);
		dw.setDateNaissance(Date.valueOf(dateNaissance));
		dw.setSexe(sexe);
		dw.setEmail(email);
		dw.setVille(Ville.valueOf(ville));
		dw.setDescription(description);
		return (Dogwalker) personnelServiceImplementation.modifierPersonnel(dw);
	}
	
	@PutMapping("/dogsitters/update")
	public Dogsitter updateDogsitter(
			@RequestParam("id") Long id ,
			@RequestParam("nom") String nom ,
			@RequestParam("prenom") String prenom ,
			@RequestParam("dateNaissance") String dateNaissance ,
			@RequestParam("sexe") String sexe ,
			@RequestParam("email") String email ,
			@RequestParam("ville") String ville,
			@RequestParam("description") String description
			//@RequestParam("image") MultipartFile file
			) throws IOException {
		Dogsitter dw = (Dogsitter) this.personnelRepository.findById(id).get();
		dw.setNom(nom);
		dw.setPrenom(prenom);
		dw.setDateNaissance(Date.valueOf(dateNaissance));
		dw.setSexe(sexe);
		dw.setEmail(email);
		dw.setVille(Ville.valueOf(ville));
		dw.setDescription(description);
		return (Dogsitter) personnelServiceImplementation.modifierPersonnel(dw);
	}
	
	@PutMapping("dressuers/update")
	public Dresseur updateDresseur(
			@RequestParam("id") Long id ,
			@RequestParam("nom") String nom ,
			@RequestParam("prenom") String prenom ,
			@RequestParam("dateNaissance") String dateNaissance ,
			@RequestParam("sexe") String sexe ,
			@RequestParam("email") String email ,
			@RequestParam("ville") String ville,
			@RequestParam("description") String description
			//@RequestParam("image") MultipartFile file
			) throws IOException {
		
		Dresseur drs = (Dresseur) this.personnelRepository.findById(id).get();
		drs.setNom(nom);
		drs.setPrenom(prenom);
		drs.setDateNaissance(Date.valueOf(dateNaissance));
		drs.setSexe(sexe);
		drs.setEmail(email);
		drs.setVille(Ville.valueOf(ville));
		drs.setDescription(description);
//		ImageModel imageModel = new ImageModel();
//		imageModel.setContent(file.getBytes());
//		ImageModel savedImageModel = this.imageModelRepository.save(imageModel);
//		drs.setImage(savedImageModel);
		return (Dresseur) personnelServiceImplementation.modifierPersonnel(drs);
	}
	
	@GetMapping("/dogwalkers/ratings/fiable/{idDogwalker}")
	public List<Rating> getDogWalkerFiableRating(@PathVariable("idDogwalker") Long idDogwalker){
		return personnelServiceImplementation.getDogWalkerFiableRating(idDogwalker);
	}
	
	@GetMapping("/dogsitters/ratings/fiable/{idDogsitter}")
	public List<Rating> getDogsitterFiableRating(@PathVariable("idDogsitter") Long idDogsitter){
		return personnelServiceImplementation.getDogsitterFiableRating(idDogsitter);
	}
	
	@GetMapping("/dogwalkers/ratings/non_fiable/{idDogwalker}")
	public List<Rating> getDogWalkerNonFiableRating(@PathVariable("idDogwalker") Long idDogwalker){
		return personnelServiceImplementation.getDogWalkerNonFiableRating(idDogwalker);
	}
	
	@GetMapping("/dogsitters/ratings/non_fiable/{idDogsitter}")
	public List<Rating> getDogsitterNonFiableRating(@PathVariable("idDogsitter") Long idDogsitter){
		return personnelServiceImplementation.getDogsitterNonFiableRating(idDogsitter);
	}
	
	@GetMapping("/dogwalkers/ratings/{idDogwalker}/{idUser}")
	public List<Rating> getDogWalkerUserRating(@PathVariable("idDogwalker") Long idDogwalker, @PathVariable("idUser")Long idUser){
		return personnelServiceImplementation.getUserRatingForDogwalker(idUser, idDogwalker);
	}
	
	@GetMapping("/dogsitters/ratings/{idDogsitter}/{idUser}")
	public List<Rating> getDogsitterUserRating(@PathVariable("idDogsitter") Long idDogsitter, @PathVariable("idUser")Long idUser){
		return personnelServiceImplementation.getUserRatingForDogsitter(idUser, idDogsitter);
	}
	
	@Autowired
	RatingServiceImplementation ratingServiceImplementation;
	
	@PostMapping("/dogwalkers/ratings/add_fiable/{idDogwalker}/{idUser}")
	public Personnel addFiable(@PathVariable("idDogwalker")Long idDogwalker, @PathVariable("idUser")Long idUser){
		return ratingServiceImplementation.addRatingFiable(idUser, idDogwalker);
	}
	
	@PostMapping("/dogsitters/ratings/add_fiable/{idDogwalker}/{idUser}")
	public Personnel addFiableDogsitter(@PathVariable("idDogwalker")Long idDogwalker, @PathVariable("idUser")Long idUser){
		return ratingServiceImplementation.addRatingFiableDogsitter(idUser, idDogwalker);
	}
	
	@PostMapping("/dogwalkers/ratings/add_non_fiable/{idDogwalker}/{idUser}")
	public Personnel addNonFiable(@PathVariable("idDogwalker")Long idDogwalker, @PathVariable("idUser")Long idUser){
		return ratingServiceImplementation.addRatingNonFiable(idUser, idDogwalker);
	}
	
	@PostMapping("/dogsitters/ratings/add_non_fiable/{idDogwalker}/{idUser}")
	public Personnel addNonFiableDogsitter(@PathVariable("idDogwalker")Long idDogwalker, @PathVariable("idUser")Long idUser){
		return ratingServiceImplementation.addRatingNonFiableDogsitter(idUser, idDogwalker);
	}
	
	@GetMapping("/dogwalkers/ratings/get_num_fiable/{idDogwalker}")
	public int getNumFiable(@PathVariable("idDogwalker")Long idDogwalker) {
		return personnelServiceImplementation.getNumberFiableDogwalker(idDogwalker);
	}
	
	@GetMapping("/dogsitters/ratings/get_num_fiable/{idDogsitter}")
	public int getNumFiableDogsitter(@PathVariable("idDogsitter")Long idDogsitter) {
		return personnelServiceImplementation.getNumberFiableDogsitter(idDogsitter);
	}

}
