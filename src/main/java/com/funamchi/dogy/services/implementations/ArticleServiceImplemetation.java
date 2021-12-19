package com.funamchi.dogy.services.implementations;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funamchi.dogy.entities.Article;
import com.funamchi.dogy.entities.Commentaire;
import com.funamchi.dogy.repositories.ArticleRepository;
import com.funamchi.dogy.repositories.UserRepository;
import com.funamchi.dogy.services.ArticleService;

@Service
public class ArticleServiceImplemetation implements ArticleService{
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CommentaireServiceImplementation commentaireServiceImplementation;

	@Override
	public List<Article> getArticle() {
		return (List<Article>) articleRepository.findAll();
	}

	@Override
	public Article addArticle(Article article, Long idUser) {
		article.setStatus("PENDING");
		article.setDateAjout(new Date(Calendar.getInstance().getTime().getTime()));
		article.setUser(userRepository.findById(idUser).get());
		return articleRepository.save(article);
	}

	@Override
	public Article updateArticle(Article article) {
		Article toBeUpdated = articleRepository.findById(article.getIdArticle()).get();
		toBeUpdated.setTitre(article.getTitre());
		toBeUpdated.setContenu(article.getContenu());
		toBeUpdated.setImage(article.getImage());
		toBeUpdated.setStatus("PENDING");
		return articleRepository.save(toBeUpdated);
	}

	@Override
	public Article acceptArticle(Long id) {
		Article article = articleRepository.findById(id).get();
		article.setStatus("ACCEPTED");
		return articleRepository.save(article);
	}

	@Override
	public Article refuseArticle(Long id) {
		Article article = articleRepository.findById(id).get();
		article.setStatus("REFUSED");
		return articleRepository.save(article);
	}

	@Override
	public List<Article> getAcceptedArticles() {
		return articleRepository.getAccepted();
	}

	@Override
	public List<Article> getPendingArticles() {
		return articleRepository.getPending();
	}

	@Override
	public Article addCommentaireToArticle(Long idArticle, Commentaire comment) {
		Article article = articleRepository.findById(idArticle).get();
		article.getCommentaires().add(comment);
		return articleRepository.save(article);
	}

	@Override
	public List<Commentaire> getCommentsOfArticle(Long id) {
		List<Commentaire> lst = new ArrayList<>();
		for(Commentaire comment : articleRepository.findById(id).get().getCommentaires()) {
			lst.add(comment);
		}
		return lst;
	}

}
