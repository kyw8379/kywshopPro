package com.example.kimshopproj.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long userId;

        @Size(min = 4, max = 20)
        private String username;

        @Size(min = 8, max = 16)
        private String password;

        @Size(min = 2, max = 8)

        private String fullName;

        private LocalDate birthDate;


        @Column(unique = true, nullable = false)
        @Size(min = 10, max = 15)
        private String phoneNumber;

        private String address;

        @Email
        private String email;

        private String bankAccount;


    }




