package com.funamchi.dogy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funamchi.dogy.entities.Commentaire;
import com.funamchi.dogy.services.implementations.CommentaireServiceImplementation;

@RestController
@RequestMapping("/comments")
public class CommentaireController {

	@Autowired
	CommentaireServiceImplementation commentaireServiceImplementation;
	
	@GetMapping("/{idUser}")
	public List<Commentaire> getCommentairesOfUser(@PathVariable("idUser") Long idUser){
		return commentaireServiceImplementation.getCommentairesOfUser(idUser);
	}
	
	@PostMapping("/add/{idUser}/{idArticle}")
	public Commentaire addCommentaire(@RequestBody Commentaire commentaire, @PathVariable("idUser")Long idUser, @PathVariable("idArticle")Long idArticle) {
		return commentaireServiceImplementation.addCommentaire(commentaire, idUser, idArticle);
	}
	
	
}
