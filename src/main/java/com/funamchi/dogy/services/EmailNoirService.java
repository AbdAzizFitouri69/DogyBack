package com.funamchi.dogy.services;

import java.util.List;

import com.funamchi.dogy.entities.EmailNoir;

public interface EmailNoirService {
	
	EmailNoir addEmailNoir(EmailNoir en);
	
	List<EmailNoir> getEmailsNoirs();
	
	void deleteEmailNoir(Long id);
	
	EmailNoir updateEmailNoir(EmailNoir en);
	
	List<EmailNoir> searchEmail(String input);

}
