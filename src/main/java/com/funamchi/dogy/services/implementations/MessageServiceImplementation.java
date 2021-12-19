package com.funamchi.dogy.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funamchi.dogy.repositories.MessageRepository;
import com.funamchi.dogy.services.MessageService;

@Service
public class MessageServiceImplementation implements MessageService{
	
	@Autowired
	MessageRepository messageRepository;

}
