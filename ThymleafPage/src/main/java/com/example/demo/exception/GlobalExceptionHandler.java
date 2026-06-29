package com.example.demo.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidUsernameException.class)
    public String handleInvalidUsername(InvalidUsernameException ex, Model model) {

        model.addAttribute("error", ex.getMessage());
        return "login";
    }

}