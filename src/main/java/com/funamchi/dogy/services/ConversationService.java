package com.funamchi.dogy.services;

import java.util.List;

import com.funamchi.dogy.entities.Conversation;
import com.funamchi.dogy.entities.Message;
import com.funamchi.dogy.entities.User;

public interface ConversationService {
	
	Conversation addConversation(Conversation conv, User initiator, User recepient);
	
	List<Conversation> getConversationsOfUser(Long idUser);
	
	List<Message> getMessagesOfConversation(Long idConversation);
	
	

}
