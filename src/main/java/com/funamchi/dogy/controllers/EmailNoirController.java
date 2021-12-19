package com.funamchi.dogy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funamchi.dogy.entities.EmailNoir;
import com.funamchi.dogy.services.implementations.EmailNoirServiceImplementation;

@RestController
@RequestMapping("/blacklist")
public class EmailNoirController {
	
	@Autowired
	EmailNoirServiceImplementation emailNoirServiceImplementation;
	
	@GetMapping("/")
	public List<EmailNoir> getBlacklist(){
		return emailNoirServiceImplementation.getEmailsNoirs();
	}
	
	@PostMapping("/add")
	public EmailNoir addToBlackList(@RequestBody EmailNoir emailNoir) {
		return this.emailNoirServiceImplementation.addEmailNoir(emailNoir);
	}
	
	@PutMapping("/update")
	public EmailNoir updateEmailNoir(@RequestBody EmailNoir emailNoir) {
		return this.emailNoirServiceImplementation.updateEmailNoir(emailNoir);
	}
	
	@GetMapping("/search/{input}")
	public List<EmailNoir> searchBlacklist(@PathVariable("input")String input){
		return this.emailNoirServiceImplementation.searchEmail(input);
	}

	
	
	
}
