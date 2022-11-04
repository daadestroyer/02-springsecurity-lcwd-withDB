package com.daadestroyer.springsecurityapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daadestroyer.springsecurityapp.entity.User;
import com.daadestroyer.springsecurityapp.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	// get all user
	public List<User> getAllUser(){
		return this.userRepo.findAll();
	}
	
	// get single user by email
	public User getSingleUser(String username) {
		return this.userRepo.findById(username).orElse(null);
	}
	
	// add new user
	public String addUser(User user) {
		this.userRepo.save(user);
		return "User Added";
	}

}
