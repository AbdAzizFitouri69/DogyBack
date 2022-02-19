package com.funamchi.dogy.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.funamchi.dogy.entities.ImageModel;

@Repository
public interface ImageModelRepository extends CrudRepository<ImageModel, Long> {

}
