package com.funamchi.dogy.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("AnnonceLost")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AnnonceLost extends Annonce{
	
	@Column(name="details")
	private String details;

}
