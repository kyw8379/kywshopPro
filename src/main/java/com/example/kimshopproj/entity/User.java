package com.example.kimshopproj.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

        @NotBlank
        @Size(min = 4, max = 20)
        private String username;

        @NotBlank
        @Size(min = 8, max = 16)
        private String password;

        @NotBlank
        @Size(min = 2, max = 8)
        private String fullName;

        private LocalDate birthDate;

        @NotBlank
        @Size(min = 10, max = 15)
        private String phoneNumber;

        @NotBlank
        private String address;

        @NotBlank
        @Email
        private String email;

        @NotBlank
        private String bankAccount;


    }




