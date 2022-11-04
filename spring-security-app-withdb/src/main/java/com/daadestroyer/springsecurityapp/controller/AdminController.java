package com.daadestroyer.springsecurityapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daadestroyer.springsecurityapp.entity.User;
import com.daadestroyer.springsecurityapp.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	
	// http://localhost:8080/admin/admin-profile
	@GetMapping("/admin-profile")
	public String adminProfile() {
		return "admin-profile";
	}

	// http://localhost:8080/admin/view-all-user
	@GetMapping("/view-all-user")
	public List<User> viewAllUser() {
		return this.userService.getAllUser();
	}
	
	// http://localhost:8080/admin/view-user-by-email/ansh@gmail.com
	@GetMapping("/view-user-by-email/{username}")
	public User viewUserByEmail(@PathVariable("username") String username) {
		return this.userService.getSingleUser(username);
	}
}
