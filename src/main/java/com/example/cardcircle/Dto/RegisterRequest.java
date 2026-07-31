package com.example.cardcircle.Dto;

import com.example.cardcircle.model.Roles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRequest(   @NotBlank(message = "Name is required")
                                 String name,

                                 @Email(message = "Invalid email")
                                 @NotBlank(message = "Email is required")
                                 String email,

                                 @NotBlank(message = "Username is required")
                                 String username,

                                 @NotBlank(message = "Password is required")
                                 String password,

                                 @NotNull(message = "Phone number is required")
                                 Long phoneNumber){


}
