package com.daadestroyer.springsecurityapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daadestroyer.springsecurityapp.entity.User;
import com.daadestroyer.springsecurityapp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user-profile")
	public String userProfile() {
		return "user-profile";
	}
	
	
	@GetMapping("/view-user-by-email/{username}")
	public User viewUserByEmail(@PathVariable("username") String username) {
		return this.userService.getSingleUser(username);
	}
	

}
