package com.funamchi.dogy.services;

import java.util.List;

import com.funamchi.dogy.entities.Dogwalker;
import com.funamchi.dogy.entities.Dresseur;
import com.funamchi.dogy.entities.Personnel;
import com.funamchi.dogy.entities.Veterinaire;

public interface PersonnelService {
	
	List<Personnel> getAllPersonels();
	
	List<Personnel> getAllVeterinaires();
	
	List<Personnel> getAllDogwalkers();
	
	List<Personnel> getAllDresseurs();
	
	Personnel addPersonnel(Personnel pers);
	
	
	Personnel modifierPersonnel(Personnel p);
	
	
	void supprimerPersonnel(Long id);

}
