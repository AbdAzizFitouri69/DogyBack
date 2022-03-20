package com.funamchi.dogy.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("AnnonceFound")
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class AnnonceFound extends Annonce{
	
	@Column(name="dressage")
	private boolean dressage;
	
	@Column(name="papiers")
	private boolean papiers;
	
	@Column(name="details")
	private String details;

}
