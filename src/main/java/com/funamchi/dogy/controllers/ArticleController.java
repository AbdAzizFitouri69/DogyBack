package com.funamchi.dogy.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.funamchi.dogy.entities.Article;
import com.funamchi.dogy.entities.Commentaire;
import com.funamchi.dogy.services.implementations.ArticleServiceImplemetation;

@RestController
@RequestMapping("/articles")
public class ArticleController {
	
	@Autowired
	ArticleServiceImplemetation articleServiceImplemetation;
	
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
	
	
	//POST METHODS
	
	@PostMapping("/add/{idUser}")
	public Article addArticle(@RequestBody Article article, @PathParam("idUser") Long idUser) {
		return articleServiceImplemetation.addArticle(article, idUser);
	}
	
	//PUT METHODS
	
	@PutMapping("/accept/{idArticle}")
	public Article acceptArticle(@PathParam("idArticle") Long idArticle) {
		return articleServiceImplemetation.acceptArticle(idArticle);
	}
	
	@PutMapping("/refuse/{idArticle}")
	public Article refuseArticle(@PathParam("idArticle") Long idArticle) {
		return articleServiceImplemetation.refuseArticle(idArticle);
	}
	
	
	//EXPERIMENTAL (ADD COMMENT TO ARTICLE
	@PutMapping("/addComment/{idArticle}")
	public Article addCommentaireToArticle(@PathParam("idArticle") Long idArticle, @RequestBody Commentaire commentaire) {
		return articleServiceImplemetation.addCommentaireToArticle(idArticle, commentaire);
	}
	
	@PutMapping("/getComments/{idArticle}")
	public List<Commentaire> getCommentsOfArticle(@PathParam("idArticle")Long idArticle) {
		return articleServiceImplemetation.getCommentsOfArticle(idArticle);
	}
	
}
