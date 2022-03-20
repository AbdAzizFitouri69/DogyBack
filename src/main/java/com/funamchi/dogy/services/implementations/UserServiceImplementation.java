package com.funamchi.dogy.services.implementations;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.funamchi.dogy.entities.EmailNoir;
import com.funamchi.dogy.entities.User;
import com.funamchi.dogy.repositories.EmailNoirRepository;
import com.funamchi.dogy.repositories.UserRepository;
import com.funamchi.dogy.services.UserService;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EmailNoirServiceImplementation emailNoirServiceImplementation;
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public List<User> getAllUsers() {
		return (List<User>)  userRepository.findAll();
	}
	
	public User getOneUser(String email) {
		return this.userRepository.searchUserByEmail(email);
	}

	@Override
	public User updateUser(User user) {
		User usr = userRepository.findById(user.getIdUser()).get();
		usr.setImage(user.getImage());
		usr.setNom(user.getNom());
		usr.setPrenom(user.getPrenom());
		usr.setVille(user.getVille());
		return null;
	}
	
	public void sendVerifMail(long idUser) throws MessagingException, UnsupportedEncodingException {
		User user = userRepository.findById(idUser).get();
		String toAddress = user.getEmail();
		String fromAddress = "dogy.platform@gmail.com";
		String senderName = "DOGY";
		String subject = "Code de Vérification";
		String content = "Cher "+user.getPrenom()+",<br>"
				+ "Voila votre code de vérification : "+user.getVerifCode()+"<br>"
						+ "L'équipe Dogy";
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setFrom(fromAddress, senderName);
		helper.setTo(toAddress);
		helper.setSubject(subject);
		helper.setText(content,true);
		
		mailSender.send(message);
	}
	
	public boolean verifVerifCode(long idUser, int verifCode) {
		User user = userRepository.findById(idUser).get();
		if(user.getVerifCode() == verifCode) {
			user.setEnabled(true);
			userRepository.save(user);
			return true;
		}
		return false;
	}

	@Override
	public User addUser(User user) {
		user.setEnabled(false);
		Random r = new Random();
		int low = 1000000000;
		int high = 2147483647;
		int res = r.nextInt(high-low)+low;
		user.setVerifCode(res);
		return userRepository.save(user);
	}

	@Override
	public List<User> searchUser(String input) {
		return userRepository.searchUser(input);
	}
	
	public void addToBlacklist(User user , String raison) {
		EmailNoir en = new EmailNoir();
		en.setEmail(user.getEmail());
		en.setRaison(raison);
		this.userRepository.delete(user);
		this.emailNoirServiceImplementation.addEmailNoir(en);
	}

}
