package com.daadestroyer.springsecurityapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daadestroyer.springsecurityapp.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String>{
	
	public User findByUserName(String username);
}
