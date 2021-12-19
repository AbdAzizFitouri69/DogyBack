package com.funamchi.dogy.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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
public class Conversation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idConversation")
	private Long idConversation;
	
	@Column(name="dateCreation")
	private Date dateCreation;
	
	@Column(name="nomConversation")
	private String nomConversation;
	
	//@ManyToMany(cascade = CascadeType.ALL)
	//private Set<User> conversation_users;
	
	@Column(name="idInitiator")
	private Long idInitiator;
	
	@Column(name="id_recepient")
	private Long idRecepient;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="conversation")
	private Set<Message> messages;

}
