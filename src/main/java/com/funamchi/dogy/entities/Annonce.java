package com.funamchi.dogy.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeAnnonce")
public class Annonce {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idAnnonce")
	private Long idAnnonce;
	
	@Column(name="titre")
	private String titre;
	
	@Column(name="description")
	private String description;
	
	@Column(name="race")
	private String race;
	
	@Column(name="age")
	private int age;
	
	@Column(name="status")
	private String status;
	
	@Column(name="createdAt")
	private Date createdAt;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="sexe")
	private SexeChien sexe;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="taille")
	private TailleChien taille;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="ville")
	private Ville ville;
	
	@ManyToOne
	private User user;
	

}
