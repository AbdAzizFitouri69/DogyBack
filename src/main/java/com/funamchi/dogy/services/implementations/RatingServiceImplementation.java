package com.funamchi.dogy.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funamchi.dogy.entities.Dogwalker;
import com.funamchi.dogy.entities.Personnel;
import com.funamchi.dogy.entities.Rating;
import com.funamchi.dogy.entities.User;
import com.funamchi.dogy.repositories.PersonnelRepository;
import com.funamchi.dogy.repositories.RatingRepository;
import com.funamchi.dogy.repositories.UserRepository;
import com.funamchi.dogy.services.RatingService;

@Service
public class RatingServiceImplementation implements RatingService{
	
	@Autowired
	RatingRepository ratingRepository;
	
	@Autowired
	PersonnelRepository personnelRepository;
	
	@Autowired
	UserRepository userRepository;

	
	public Personnel addRatingFiable(Long idUser, Long idPersonnel) {
		User user = userRepository.findById(idUser).get();
		Dogwalker dw = (Dogwalker)  personnelRepository.findById(idPersonnel).get();
		for (Rating rt : dw.getRatings()) {
			if(rt.getUser().getIdUser() == idUser) {
				dw.getRatings().remove(rt);
				ratingRepository.deleteById(rt.getIdRating());
				break;
			}
		}
		Rating rating = new Rating();
		rating.setUser(user);
		rating.setDogwalker(dw);
		rating.setFiable(true);
		rating.setNon_fiable(false);
		dw.getRatings().add(this.ratingRepository.save(rating));
		return personnelRepository.save(dw);
	}
	
	public Personnel addRatingNonFiable(Long idUser, Long idPersonnel) {
		User user = userRepository.findById(idUser).get();
		Dogwalker dw = (Dogwalker)  personnelRepository.findById(idPersonnel).get();
		for (Rating rt : dw.getRatings()) {
			if(rt.getUser().getIdUser() == idUser) {
				dw.getRatings().remove(rt);
				ratingRepository.deleteById(rt.getIdRating());
				break;
			}
		}
		Rating rating = new Rating();
		rating.setUser(user);
		rating.setDogwalker(dw);
		rating.setFiable(false);
		rating.setNon_fiable(true);
		dw.getRatings().add(this.ratingRepository.save(rating));
		return personnelRepository.save(dw);
	}
	

}
