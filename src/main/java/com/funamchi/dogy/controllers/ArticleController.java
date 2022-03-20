package com.funamchi.dogy.controllers;

import java.io.IOException;
import java.util.List;

import javax.websocket.server.PathParam;

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

import com.funamchi.dogy.entities.Article;
import com.funamchi.dogy.entities.Commentaire;
import com.funamchi.dogy.entities.ImageModel;
import com.funamchi.dogy.repositories.ImageModelRepository;
import com.funamchi.dogy.services.implementations.ArticleServiceImplemetation;

@RestController
@RequestMapping("/articles")
public class ArticleController {
	
	@Autowired
	ArticleServiceImplemetation articleServiceImplemetation;
	
	@Autowired
	ImageModelRepository imageModelRepository;
	
	//GET METHODS
	
	@GetMapping("/")
	public List<Article> listArticles(){
		return articleServiceImplemetation.getArticle();
	}
	
	
	@GetMapping("/accepted")
	public List<Article> listAcceptedArticles(){
		return articleServiceImplemetation.getAcceptedArticles();
	}
	
	@GetMapping("/pending")
	public List<Article> listPendingArticles(){
		return articleServiceImplemetation.getPendingArticles();
	}
	
	@GetMapping("/{idUser}")
	public List<Article> getUsersArticles(@PathVariable("idUser")Long idUser){
		return articleServiceImplemetation.getUserArticles(idUser);
	}
	
	
	//POST METHODS
	
	@PostMapping("/add")
	public Article addArticle(
			@RequestParam("titre")String titre,
			@RequestParam("contenu")String contenu,
			@RequestParam("image") MultipartFile file,
			@RequestParam("idUser") Long idUser) throws IOException{
		Article article = new Article();
		article.setTitre(titre);
		article.setContenu(contenu);
		ImageModel imageModel = new ImageModel();
		imageModel.setContent(file.getBytes());
		ImageModel savedImageModel = this.imageModelRepository.save(imageModel);
		article.setImage(savedImageModel);
		return articleServiceImplemetation.addArticle(article, idUser);
	}
	
	//PUT METHODS
	
	@PutMapping("/accept/{idArticle}")
	public Article acceptArticle(@PathVariable("idArticle") Long idArticle) {
		return articleServiceImplemetation.acceptArticle(idArticle);
	}
	
	@PutMapping("/refuse/{idArticle}")
	public Article refuseArticle(@PathVariable("idArticle") Long idArticle) {
		return articleServiceImplemetation.refuseArticle(idArticle);
	}
	
	
	//EXPERIMENTAL (ADD COMMENT TO ARTICLE
	@PutMapping("/addComment/{idArticle}/{idUser}")
	public Article addCommentaireToArticle(@PathVariable("idUser")Long idUser,@PathVariable("idArticle") Long idArticle, @RequestParam String content) {
		Commentaire commentaire = new Commentaire();
		commentaire.setContenu(content);
		return articleServiceImplemetation.addCommentaireToArticle(idArticle, idUser, commentaire);
	}
	
	@GetMapping("/getComments/{idArticle}")
	public List<Commentaire> getCommentsOfArticle(@PathVariable("idArticle")Long idArticle) {
		return articleServiceImplemetation.getCommentsOfArticle(idArticle);
	}
	
}
