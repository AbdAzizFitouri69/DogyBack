package com.funamchi.dogy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.funamchi.dogy.entities.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long>{
	
	@Query(value = "SELECT * FROM Article a WHERE a.status = 'ACCEPTED' ORDER BY a.id_article DESC", nativeQuery = true)
	public List<Article> getAccepted();
	
	@Query(value = "SELECT * FROM Article a WHERE a.status = 'PENDING' ORDER BY a.id_article DESC", nativeQuery = true)
	public List<Article> getPending();
	
	@Query(value = "SELECT * FROM Article a WHERE a.status = 'ACCEPTED' ORDER BY a.titre", nativeQuery = true)
	public List<Article> getAcceptedArticlesAscending();
	
	@Query(value = "SELECT * FROM Article a WHERE a.status = 'ACCEPTED' ORDER BY a.titre DESC", nativeQuery = true)
	public List<Article> getAcceptedArticlesDescending();
	
	@Query(value = "SELECT * FROM Article a WHERE a.status = 'ACCEPTED' ORDER BY a.dateAjout", nativeQuery = true)
	public List<Article> getAcceptedArticlesOrdredByDate();
	
	@Query(value = "SELECT * FROM Article a WHERE a.status = 'ACCEPTED' AND a.user.idUser == :idUser", nativeQuery = true)
	public List<Article> getUserAcceptedArticles(@Param("idUser")Long idUser);
	
	@Query(value = "SELECT * FROM Article a WHERE a.user_id_user = :idUser ORDER BY a.id_article DESC", nativeQuery = true)
	public List<Article> getUserArticles(@Param("idUser")Long idUser);
}
