package com.example.cardcircle.service;

import com.example.cardcircle.Dto.LoginRequest;
import com.example.cardcircle.Dto.RegisterRequest;
import com.example.cardcircle.model.Roles;

public interface UserAuth {

    String CreateUser(RegisterRequest registerRequest);

    String LoginUser(LoginRequest loginRequest);

    String VerifyOtpEmail(String email, String OTP);
    String VerifyOtpEmail(Long PhoneNumber, String OTP);
}
