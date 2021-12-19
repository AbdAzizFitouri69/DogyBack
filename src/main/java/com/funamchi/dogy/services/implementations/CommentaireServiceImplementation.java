package com.funamchi.dogy.services.implementations;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funamchi.dogy.entities.Article;
import com.funamchi.dogy.entities.Commentaire;
import com.funamchi.dogy.entities.User;
import com.funamchi.dogy.repositories.ArticleRepository;
import com.funamchi.dogy.repositories.CommentaireRepository;
import com.funamchi.dogy.repositories.UserRepository;
import com.funamchi.dogy.services.CommentaireService;

@Service
public class CommentaireServiceImplementation implements CommentaireService{
	
	@Autowired
	CommentaireRepository commentaireRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ArticleRepository articleRepository;

	@Override
	public Commentaire addCommentaire(Commentaire commentaire, Long idUser, Long idArticle) {
		User user = userRepository.findById(idUser).get();
		Article article = articleRepository.findById(idArticle).get();
		commentaire.setUser(user);
		commentaire.setArticle(article);
		commentaire.setDateAjout(new Date(Calendar.getInstance().getTime().getTime()));
		return commentaireRepository.save(commentaire);
	}

	@Override
	public List<Commentaire> getCommentairesOfUser(Long idUser) {
		return commentaireRepository.getCommentsOfUser(idUser);
	}

}
