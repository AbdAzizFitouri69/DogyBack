package com.funamchi.dogy.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("Dogwalker")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Dogwalker extends Personnel{
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="dogwalker")
	private Set<Rating> ratings ;
	
	public Dogwalker() {
		super();
	}
	
}
