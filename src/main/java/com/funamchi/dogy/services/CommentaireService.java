package com.funamchi.dogy.services;

import java.util.List;

import com.funamchi.dogy.entities.Commentaire;

public interface CommentaireService {
	
	Commentaire addCommentaire(Commentaire commentaire, Long idUser, Long idArticle);
	
	//Commentaire updateCommentaire(Commentaire commentaire);
	
	List<Commentaire> getCommentairesOfUser(Long idUser);
	
	

}
