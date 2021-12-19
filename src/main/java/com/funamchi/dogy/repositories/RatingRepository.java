package com.funamchi.dogy.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.funamchi.dogy.entities.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long>{
	

}
