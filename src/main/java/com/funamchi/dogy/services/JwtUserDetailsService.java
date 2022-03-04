package com.funamchi.dogy.services;

import java.util.ArrayList;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;

import com.funamchi.dogy.entities.User;
import com.funamchi.dogy.services.implementations.UserServiceImplementation;

//@Service
public class JwtUserDetailsService /*implements UserDetailsService*/{
	
//	@Autowired
//	public UserServiceImplementation userServiceImplementation;
//	
////	@Override
////	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
////		User user = this.userServiceImplementation.getOneUser(email);
////		if(user != null) {
////			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword() , new ArrayList<>());
////		}
////		else {
////			throw new UsernameNotFoundException("User not found with Email: " + email);
////		}
////	}
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		if ("javainuse".equals(username)) {
//			return new org.springframework.security.core.userdetails.User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//	}

}
