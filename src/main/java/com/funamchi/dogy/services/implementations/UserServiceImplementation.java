package com.funamchi.dogy.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funamchi.dogy.entities.User;
import com.funamchi.dogy.repositories.UserRepository;
import com.funamchi.dogy.services.UserService;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return (List<User>)  userRepository.findAll();
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

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> searchUser(String input) {
		return userRepository.searchUser(input);
	}

}
