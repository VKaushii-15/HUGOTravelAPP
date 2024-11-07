package com.example.HUGOTravelPlanner.controller;

import com.example.HUGOTravelPlanner.repository.UserRepository;
//import com.example.HUGOTravelPlanner.model.User;
import com.example.HUGOTravelPlanner.service.UserService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @PostMapping("/users")
    public RedirectView registerUser(
        @RequestParam("username") String username,
        @RequestParam("phoneNumber") String phoneNumber,
        @RequestParam("email") String email
    ) {
        try {
            userRepository.useapp();
            userRepository.insertIgnoreUser(username,phoneNumber,email);
            userService.createItenerary(phoneNumber);
            userService.usephone(phoneNumber);
            userRepository.existItenerary();
            return new RedirectView("/home.html");
        } catch (Exception e) {
            e.printStackTrace(); 
            return new RedirectView("/error.html"); 
        }
    }
}

