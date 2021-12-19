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
@DiscriminatorValue("AnnonceAccouplement")
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class AnnonceAccouplement extends Annonce{
	
	@Column(name="dressage")
	private boolean dressage;
	
	@Column(name="papiers")
	private boolean papiers;
	
}
