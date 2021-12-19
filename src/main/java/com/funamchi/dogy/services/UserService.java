package com.funamchi.dogy.services;

import java.util.List;

import com.funamchi.dogy.entities.User;

public interface UserService {

	List<User> getAllUsers();
	
	User updateUser(User user);
	
	User addUser(User user);
	
	List<User> searchUser(String input);
	
}
