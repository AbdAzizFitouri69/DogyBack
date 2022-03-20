package com.funamchi.dogy.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idArticle")
	private Long idArticle;
	
	@Column(name="titre")
	private String titre;
	
	@Column(name="contenu")
	private String contenu;
	
	@OneToOne
	private ImageModel image;
	
	@Column(name="dateAjout")
	private Date dateAjout;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="article")
	private Set<Commentaire> commentaires;

}
