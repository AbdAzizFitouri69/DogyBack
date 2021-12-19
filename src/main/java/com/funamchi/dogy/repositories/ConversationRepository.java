package com.funamchi.dogy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.funamchi.dogy.entities.Conversation;

@Repository
public interface ConversationRepository extends CrudRepository<Conversation, Long>{

	@Query(value="SELECT * FROM Conversation c WHERE c.idInitiator == :id || c.idRecepient == :id", nativeQuery = true)
	public List<Conversation> findConversationsOfCurrentUser(@Param("id") Long id);
	
}
