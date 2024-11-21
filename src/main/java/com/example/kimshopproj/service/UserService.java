package com.example.kimshopproj.service;


import com.example.kimshopproj.entity.User;
import com.example.kimshopproj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public String registerUser(User user) {
               // 만들어진 아이디 중복사용을 막아줌
        Optional<User> existingUserByUsername = userRepository.findByUsername(user.getUsername());
        if (existingUserByUsername.isPresent()) {
            return "이미 존재하는 아이디입니다.";
        }

             // 만들어진 이메일 중복사용을 막아줌
        Optional<User> existingUserByEmail = userRepository.findByEmail(user.getEmail());
        if (existingUserByEmail.isPresent()) {
            return "이미 존재하는 이메일입니다.";
        }


        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);


        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}
