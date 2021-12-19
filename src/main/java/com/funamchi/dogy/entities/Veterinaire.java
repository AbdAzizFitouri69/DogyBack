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
@DiscriminatorValue("Veterinaire")
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Veterinaire extends Personnel{
	
	@Column(name="horraire")
	private String horraire;

}
