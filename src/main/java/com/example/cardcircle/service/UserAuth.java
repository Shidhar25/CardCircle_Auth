package com.example.cardcircle.service;

import com.example.cardcircle.Dto.AuthResponse;
import com.example.cardcircle.Dto.LoginRequest;
import com.example.cardcircle.Dto.RegisterRequest;
import com.example.cardcircle.Dto.UserResponse;

public interface UserAuth {

    UserResponse CreateUser(RegisterRequest registerRequest);

    AuthResponse LoginUser(LoginRequest loginRequest);

    
}
