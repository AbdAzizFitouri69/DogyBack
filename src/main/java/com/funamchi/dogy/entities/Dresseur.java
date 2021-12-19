package com.funamchi.dogy.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("Dresseur")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Dresseur extends Personnel{

}
