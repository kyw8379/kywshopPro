package com.example.kimshopproj.controller;

import com.example.kimshopproj.entity.User;
import com.example.kimshopproj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        String result = userService.registerUser(user);
        model.addAttribute("message", result);
        return "user/main";
    }
}
