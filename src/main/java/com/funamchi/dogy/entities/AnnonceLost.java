package com.funamchi.dogy.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("AnnonceLost")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class AnnonceLost extends Annonce{

}
