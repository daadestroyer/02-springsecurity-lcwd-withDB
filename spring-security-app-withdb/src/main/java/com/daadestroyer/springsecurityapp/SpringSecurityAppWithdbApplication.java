package com.daadestroyer.springsecurityapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.daadestroyer.springsecurityapp.entity.User;
import com.daadestroyer.springsecurityapp.repo.UserRepo;

@SpringBootApplication
public class SpringSecurityAppWithdbApplication implements CommandLineRunner{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAppWithdbApplication.class, args);
		System.out.println("==============================");
		System.out.println("====Application Started====");
		System.out.println("==============================");
	}
	
	public void run(String... args) {
		User user = new User();
		user.setUserName("admin");
		user.setPassword(this.bCryptPasswordEncoder.encode("admin"));
		user.setEmail("admin@gmail.com");
		user.setRole("ROLE_ADMIN");
		this.userRepo.save(user);
		
		User user1 = new User();
		user1.setUserName("shubham");
		user1.setPassword(this.bCryptPasswordEncoder.encode("shubham"));
		user1.setEmail("shubham@gmail.com");
		user1.setRole("ROLE_NORMAL");
		this.userRepo.save(user1);
	}

}
