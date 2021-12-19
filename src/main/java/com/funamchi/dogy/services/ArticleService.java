package com.funamchi.dogy.services;

import java.util.List;

import com.funamchi.dogy.entities.Article;
import com.funamchi.dogy.entities.Commentaire;

public interface ArticleService {

	List<Article> getArticle();

	Article addArticle(Article article, Long idUser);

	Article updateArticle(Article article);

	Article acceptArticle(Long id);

	Article refuseArticle(Long id);

	List<Article> getAcceptedArticles();

	List<Article> getPendingArticles();
	
	Article addCommentaireToArticle(Long idArticle, Commentaire comment);
	
	List<Commentaire> getCommentsOfArticle(Long id);

}
