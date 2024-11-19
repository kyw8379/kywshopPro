package com.example.kimshopproj.controller;

import com.example.kimshopproj.entity.User;
import com.example.kimshopproj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";  // 회원가입 폼을 위한 HTML 페이지 (Thymeleaf)
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        String result = userService.registerUser(user);
        model.addAttribute("message", result);
        return "registration-result";
    }
}
