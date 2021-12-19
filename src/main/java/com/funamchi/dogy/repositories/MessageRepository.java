package com.funamchi.dogy.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.funamchi.dogy.entities.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{

}
