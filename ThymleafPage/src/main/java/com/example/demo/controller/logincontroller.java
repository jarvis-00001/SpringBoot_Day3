package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.exception.InvalidUsernameException;

@Controller
public class logincontroller {

    @GetMapping("/login")
    public String showloginpage() {
        return "login";
    }

    @PostMapping("/login")
    public String handlelogin(@RequestParam String username,
                              @RequestParam String password,
                              Model model) {

        if (!username.equals("admin")) {
            throw new InvalidUsernameException("Username does not exist.");
        }

        if (!password.equals("1234")) {
            model.addAttribute("error", "Incorrect password");
            return "login";
        }

        model.addAttribute("username", username);
        return "welcome";
    }
}