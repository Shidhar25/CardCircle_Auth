package com.example.cardcircle.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.springframework.context.annotation.Role;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    private Long id;
    private String name;
    @Email
    private String email;
    private String UserName;
    private String Password;
    @NumberFormat
    private Long PhoneNumber;
    private  Roles role;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
