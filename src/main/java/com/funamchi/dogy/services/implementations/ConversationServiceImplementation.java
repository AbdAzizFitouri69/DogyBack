package com.funamchi.dogy.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funamchi.dogy.entities.Conversation;
import com.funamchi.dogy.entities.Message;
import com.funamchi.dogy.entities.User;
import com.funamchi.dogy.repositories.ConversationRepository;
import com.funamchi.dogy.services.ConversationService;

@Service
public class ConversationServiceImplementation implements ConversationService{
	
	@Autowired
	ConversationRepository conversationRepository;

	@Override
	public Conversation addConversation(Conversation conv, User initiator, User recepient) {
		return conversationRepository.save(conv);
	}

	@Override
	public List<Conversation> getConversationsOfUser(Long idUser) {
		return conversationRepository.findConversationsOfCurrentUser(idUser);
	}

	@Override
	public List<Message> getMessagesOfConversation(Long idConversation) {
		List<Message> msgs = new ArrayList<>();
		for(Message message : conversationRepository.findById(idConversation).get().getMessages()) {
			msgs.add(message);
		}
		return msgs;
	}

}
