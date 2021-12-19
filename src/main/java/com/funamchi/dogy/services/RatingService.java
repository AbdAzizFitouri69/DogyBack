package com.funamchi.dogy.services;

import com.funamchi.dogy.entities.Rating;

public interface RatingService {
	
	Rating addRating(Rating rating, Long idUser, Long idPersonnel);

}
