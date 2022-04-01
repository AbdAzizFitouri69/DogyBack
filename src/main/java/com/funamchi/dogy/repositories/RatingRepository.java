package com.funamchi.dogy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.funamchi.dogy.entities.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long>{
	
	@Query(value="SELECT * FROM Rating r WHERE r.user_id_user = :idUser AND r.dogwalker_id_personnel = :idDogwalker", nativeQuery = true)
	public List<Rating> getUserRatingToDogWalker(@Param("idUser")Long idUser, @Param("idDogwalker")Long idDogwalker);
	
	@Query(value="SELECT COUNT(*) FROM Rating r WHERE r.dogwalker_id_personnel = :idDogwalker AND r.fiable = 1", nativeQuery = true)
	public int getFiableNumber(@Param("idDogwalker")Long idDogwalker);
	
	@Query(value="SELECT * FROM Rating r WHERE r.user_id_user = :idUser AND r.dogsitter_id_personnel = :idDogsitter", nativeQuery = true)
	public List<Rating> getUserRatingToDogsitter(@Param("idUser")Long idUser, @Param("idDogsitter")Long idDogsitter);
	
	@Query(value="SELECT COUNT(*) FROM Rating r WHERE r.dogsitter_id_personnel = :idDogsitter AND r.fiable = 1", nativeQuery = true)
	public int getFiableNumberDogsitter(@Param("idDogsitter")Long idDogsitter);

	

}
