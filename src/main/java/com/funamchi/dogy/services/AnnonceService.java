package com.funamchi.dogy.services;

import java.util.List;

import com.funamchi.dogy.entities.Annonce;
import com.funamchi.dogy.entities.AnnonceAccouplement;
import com.funamchi.dogy.entities.AnnonceFound;
import com.funamchi.dogy.entities.AnnonceLost;
import com.funamchi.dogy.entities.AnnonceVente;

public interface AnnonceService {
	
	List<Annonce> getAnnonces();
	
	Annonce addAnnonce(Annonce annonce, Long idUser);
	
	Annonce updateAnnonce(Annonce annonce);
	
	Annonce acceptAnnonce(Long id);
	
	Annonce refuseAnnonce(Long id);
	
	List<Annonce> getAcceptedAnnonces();
	
	List<Annonce> getPendingAnnonces();
	
	List<Annonce> getAnnoncesAccouplements();
	
	List<Annonce> getAnnonceVente();
	
	List<Annonce> getAnnonceLost();
	
	List<Annonce> getAnnonceFound();
	
	
}
