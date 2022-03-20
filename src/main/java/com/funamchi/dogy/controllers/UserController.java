package com.funamchi.dogy.controllers;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funamchi.dogy.entities.User;
import com.funamchi.dogy.services.implementations.UserServiceImplementation;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserServiceImplementation userServiceImplementation;
	
	@GetMapping("/")
	public List<User> getUsers(){
		return userServiceImplementation.getAllUsers();
	}
	
	@GetMapping("/getOne/{email}")
	public User getOneUser(@PathVariable("email")String email) {
		return this.userServiceImplementation.getOneUser(email);
	}
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		user.setRole("Client");
		return userServiceImplementation.addUser(user);
	}
	
	@PostMapping("/addAdmin")
	public User addAdmin(@RequestBody User user) {
		user.setRole("Admin");
		return userServiceImplementation.addUser(user);
	}
	
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return userServiceImplementation.updateUser(user);
	}
	
	@GetMapping("/search/{input}")
	public List<User> searchUser(@PathVariable("input") String input){
		return userServiceImplementation.searchUser(input);
	}
	
	@PostMapping("/toBlackList/{reason}")
	public void addToBlacklist(@RequestBody User user, @PathVariable("reason") String reason) {
		this.userServiceImplementation.addToBlacklist(user, reason);
	}
	
	@PostMapping("/sendVerifCode/{idUser}")
	public void sendVerifCode(@PathVariable("idUser")long idUser) throws UnsupportedEncodingException, MessagingException {
		this.userServiceImplementation.sendVerifMail(idUser);
	}
	
	@GetMapping("checkVerifCode/{idUser}/{verifCode}")
	public boolean checkVerifCode(@PathVariable("idUser")long idUser, @PathVariable("verifCode")int verifCode) {
		return this.userServiceImplementation.verifVerifCode(idUser, verifCode);
	}
	
	

}
