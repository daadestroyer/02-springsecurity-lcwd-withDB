package com.daadestroyer.springsecurityapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.daadestroyer.springsecurityapp.entity.CustomUserDetail;
import com.daadestroyer.springsecurityapp.entity.User;
import com.daadestroyer.springsecurityapp.repo.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = this.userRepo.findByUserName(email);
		if (user == null) {
			throw new UsernameNotFoundException("NO USER FOUND");
		}

		return new CustomUserDetail(user);
	}

	

}
