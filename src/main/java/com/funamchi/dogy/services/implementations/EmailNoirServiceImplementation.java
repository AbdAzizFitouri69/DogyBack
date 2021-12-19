package com.funamchi.dogy.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funamchi.dogy.entities.EmailNoir;
import com.funamchi.dogy.repositories.EmailNoirRepository;
import com.funamchi.dogy.services.EmailNoirService;

@Service
public class EmailNoirServiceImplementation implements EmailNoirService{
	
	@Autowired
	EmailNoirRepository emailNoirRepository;

	@Override
	public EmailNoir addEmailNoir(EmailNoir en) {
		return emailNoirRepository.save(en);
	}

	@Override
	public List<EmailNoir> getEmailsNoirs() {
		return (List<EmailNoir>) emailNoirRepository.findAll();
	}

	@Override
	public void deleteEmailNoir(Long id) {
		emailNoirRepository.deleteById(id);
	}

	@Override
	public EmailNoir updateEmailNoir(EmailNoir en) {
		EmailNoir toBeUpdated = emailNoirRepository.findById(en.getIdEmailNoir()).get();
		toBeUpdated.setEmail(en.getEmail());
		toBeUpdated.setRaison(en.getRaison());
		return emailNoirRepository.save(en);
	}

	@Override
	public List<EmailNoir> searchEmail(String input) {
		return this.emailNoirRepository.searchEmail(input);
	}

}
