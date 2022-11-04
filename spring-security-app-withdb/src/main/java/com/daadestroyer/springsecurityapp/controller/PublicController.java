package com.daadestroyer.springsecurityapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicController {

	@GetMapping("/common1")
	public String common1() {
		return "index.html";
	}

	@GetMapping("/signin")
	public String signin() {
		return "signin.html";
	}
	
	@GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard.html";
    }
}
