package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class logincontroller {
	
	@GetMapping("/login")
	public String showloginpage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String handlelogin(@RequestParam String username, @RequestParam String password, Model model) {
		if(username.equals("admin") && password.equals("1234")) {
			model.addAttribute("username", username);
			return "welcome";
		}
		else {
			model.addAttribute("error", "Invalid username or password");
			return "login";
		}
	}
}
