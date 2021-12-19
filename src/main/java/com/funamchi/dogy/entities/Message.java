package com.funamchi.dogy.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idMessage")
	private Long idMessage;
	
	@Column(name="contenu")
	private String contenu;
	
	@Column(name="dateEnvoi")
	private Date dateEnvoi;
	
	@ManyToOne
	private Conversation conversation;
	
	@ManyToOne
	private User user;
	

}
