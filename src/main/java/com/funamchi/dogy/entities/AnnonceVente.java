package com.funamchi.dogy.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("AnnonceVente")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AnnonceVente extends Annonce{

	@Column(name="prix")
	private float prix;
	
	@Column(name="dressage")
	private boolean dressage;
	
	@Column(name="papiers")
	private boolean papiers;
	
}
