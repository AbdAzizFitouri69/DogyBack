package com.funamchi.dogy.controllers;

import java.io.IOException;
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

import com.funamchi.dogy.entities.Annonce;
import com.funamchi.dogy.entities.AnnonceAccouplement;
import com.funamchi.dogy.entities.AnnonceFound;
import com.funamchi.dogy.entities.AnnonceLost;
import com.funamchi.dogy.entities.AnnonceVente;
import com.funamchi.dogy.entities.ImageModel;
import com.funamchi.dogy.entities.SexeChien;
import com.funamchi.dogy.entities.TailleChien;
import com.funamchi.dogy.entities.Ville;
import com.funamchi.dogy.repositories.ImageModelRepository;
import com.funamchi.dogy.services.implementations.AnnonceServiceImplementation;

@RestController
@RequestMapping("/annonces")
public class AnnonceController {

	@Autowired
	AnnonceServiceImplementation annonceServiceImplementation;

	@Autowired
	ImageModelRepository imageModelRepository;

	@GetMapping("/")
	public List<Annonce> getAnnonces() {
		return annonceServiceImplementation.getAnnonces();
	}

	@GetMapping("/accouplement")
	public List<Annonce> getAnnoncesAccouplement() {
		return annonceServiceImplementation.getAnnoncesAccouplements();
	}

	@GetMapping("/vente")
	public List<Annonce> getAnnoncesVente() {
		return annonceServiceImplementation.getAnnonceVente();
	}

	@GetMapping("/lost")
	public List<Annonce> getAnnoncesLost() {
		return annonceServiceImplementation.getAnnonceLost();
	}

	@GetMapping("/found")
	public List<Annonce> getAnnoncesFound() {
		return annonceServiceImplementation.getAnnonceFound();
	}

	@GetMapping("/pending")
	public List<Annonce> getPendingAnnonce() {
		return annonceServiceImplementation.getPendingAnnonces();
	}

	@GetMapping("/accepted")
	public List<Annonce> getAcceptedAnnonce() {
		return annonceServiceImplementation.getAcceptedAnnonces();
	}
	
	@GetMapping("/accepted/{city}")
	public List<Annonce> getAcceptedAnnonceByCity(@PathVariable("city")String city){
		return annonceServiceImplementation.getAcceptedAnnoncesCity(city);
	}

	@GetMapping("/resolved")
	public List<Annonce> getResolvedAnnonce() {
		return annonceServiceImplementation.getResolvedAnnonces();
	}

	@GetMapping("/found/accepted")
	public List<AnnonceFound> getAcceptedFound() {
		return annonceServiceImplementation.getAcceptedFound();
	}

	@GetMapping("/lost/accepted")
	public List<AnnonceLost> getAcceptedLost() {
		return annonceServiceImplementation.getAcceptedLost();
	}

	@GetMapping("/accouplement/accepted")
	public List<AnnonceAccouplement> getAcceptedAccouplement() {
		return annonceServiceImplementation.getAcceptedAccouplement();
	}

	@GetMapping("/vente/accepted")
	public List<AnnonceVente> getAcceptedVente() {
		return annonceServiceImplementation.getAcceptedVente();
	}

	@GetMapping("/vente/accepted/{city}")
	public List<AnnonceVente> getAcceptedVenteByCity(@PathVariable("city") String city) {
		return annonceServiceImplementation.getCurrentCityVente(city);
	}

	@GetMapping("/accouplement/accepted/{city}")
	public List<AnnonceAccouplement> getAcceptedAccouplementByCity(@PathVariable("city") String city) {
		return annonceServiceImplementation.getCurrentCityAccouplement(city);
	}
	
	

	@GetMapping("/lost/accepted/{city}")
	public List<AnnonceLost> getAcceptedLostCity(@PathVariable("city") String city) {
		return annonceServiceImplementation.getCurrentCityLost(city);
	}

	@GetMapping("/found/accepted/{city}")
	public List<AnnonceFound> getAcceptedFoundCity(@PathVariable("city") String city) {
		return annonceServiceImplementation.getCurrentCityFound(city);
	}

	@PostMapping("/accouplement/add/{idUser}")
	public Annonce addAccouplement(@RequestParam("titre") String titre, @RequestParam("race") String race,
			@RequestParam("age") String age, @RequestParam("sexe") String sexe, @RequestParam("taille") String taille,
			@RequestParam("ville") String ville, @RequestParam("image") MultipartFile file,
			@RequestParam("dressage") boolean dressage, @RequestParam("papiers") boolean papiers,
			@PathVariable("idUser") Long idUser) throws IOException {
		AnnonceAccouplement ac = new AnnonceAccouplement();
		ac.setTitre(titre);
		ac.setTaille(TailleChien.valueOf(taille));
		ac.setRace(race);
		ac.setAge(age);
		ac.setSexe(SexeChien.valueOf(sexe));
		ac.setVille(Ville.valueOf(ville));
		ImageModel imageModel = new ImageModel();
		imageModel.setContent(file.getBytes());
		ImageModel savedImageModel = this.imageModelRepository.save(imageModel);
		ac.setImage(savedImageModel);
		ac.setDressage(dressage);
		ac.setPapiers(papiers);
		return annonceServiceImplementation.addAnnonce(ac, idUser);
	}

	@PostMapping("/vente/add/{idUser}")
	public Annonce addVente(@RequestParam("titre") String titre, @RequestParam("race") String race,
			@RequestParam("age") String age, @RequestParam("sexe") String sexe, @RequestParam("taille") String taille,
			@RequestParam("ville") String ville, @RequestParam("image") MultipartFile file,
			@RequestParam("dressage") boolean dressage, @RequestParam("papiers") boolean papiers,
			@RequestParam("prix") float prix, @PathVariable("idUser") Long idUser) throws IOException {
		AnnonceVente vente = new AnnonceVente();
		vente.setTitre(titre);
		vente.setTaille(TailleChien.valueOf(taille));
		vente.setRace(race);
		vente.setAge(age);
		vente.setSexe(SexeChien.valueOf(sexe));
		vente.setVille(Ville.valueOf(ville));

		ImageModel imageModel = new ImageModel();
		imageModel.setContent(file.getBytes());
		ImageModel savedImageModel = this.imageModelRepository.save(imageModel);
		vente.setImage(savedImageModel);

		vente.setDressage(dressage);
		vente.setPapiers(papiers);
		vente.setPrix(prix);
		return annonceServiceImplementation.addAnnonce(vente, idUser);
	}

	@PostMapping("/lost/add/{idUser}")
	public Annonce addLost(@RequestParam("titre") String titre, @RequestParam("race") String race,
			@RequestParam("age") String age, @RequestParam("sexe") String sexe, @RequestParam("taille") String taille,
			@RequestParam("ville") String ville, @RequestParam("details") String details,
			@RequestParam("image") MultipartFile file, @PathVariable("idUser") Long idUser) throws IOException {
		AnnonceLost lost = new AnnonceLost();
		lost.setTitre(titre);
		lost.setTaille(TailleChien.valueOf(taille));
		lost.setRace(race);
		lost.setAge(age);
		lost.setSexe(SexeChien.valueOf(sexe));
		lost.setVille(Ville.valueOf(ville));

		ImageModel imageModel = new ImageModel();
		imageModel.setContent(file.getBytes());
		ImageModel savedImageModel = this.imageModelRepository.save(imageModel);
		lost.setImage(savedImageModel);

		lost.setDetails(details);
		return annonceServiceImplementation.addAnnonce(lost, idUser);
	}

	@PostMapping("/found/add/{idUser}")
	public Annonce addFound(@RequestParam("titre") String titre, @RequestParam("race") String race,
			@RequestParam("age") String age, @RequestParam("sexe") String sexe, @RequestParam("taille") String taille,
			@RequestParam("ville") String ville, @RequestParam("details") String details,
			@RequestParam("image") MultipartFile file, @PathVariable("idUser") Long idUser) throws IOException {
		AnnonceFound found = new AnnonceFound();
		found.setTitre(titre);
		found.setTaille(TailleChien.valueOf(taille));
		found.setRace(race);
		found.setAge(age);
		found.setSexe(SexeChien.valueOf(sexe));
		found.setVille(Ville.valueOf(ville));

		ImageModel imageModel = new ImageModel();
		imageModel.setContent(file.getBytes());
		ImageModel savedImageModel = this.imageModelRepository.save(imageModel);
		found.setImage(savedImageModel);

		found.setDetails(details);
		return annonceServiceImplementation.addAnnonce(found, idUser);
	}

	@PutMapping("/accept/{idAnnonce}")
	public Annonce acceptAnnonce(@PathVariable("idAnnonce") Long idAnnonce) {
		return annonceServiceImplementation.acceptAnnonce(idAnnonce);
	}

	@PutMapping("/refuse/{idAnnonce}")
	public Annonce refuseAnnonce(@PathVariable("idAnnonce") Long idAnnonce) {
		return annonceServiceImplementation.refuseAnnonce(idAnnonce);
	}

	@PutMapping("/resolve/{idAnnonce}")
	public Annonce resoudreAnnonce(@PathVariable("idAnnonce") Long idAnnonce) {
		return annonceServiceImplementation.resolveAnnonce(idAnnonce);
	}

	@GetMapping("/{id}")
	public List<Annonce> getCurrentUserAnnonces(@PathVariable("id") Long id) {
		return annonceServiceImplementation.getUserAnnonce(id);
	}

}
