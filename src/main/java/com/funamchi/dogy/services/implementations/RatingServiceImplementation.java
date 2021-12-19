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

	@Override
	public Rating addRating(Rating rating, Long idUser, Long idPersonnel) {
		User user = userRepository.findById(idUser).get();
		Dogwalker dw = (Dogwalker)  personnelRepository.findById(idPersonnel).get();
		rating.setDogwalker(dw);
		rating.setUser(user);
		return ratingRepository.save(rating);
	}
	

}
