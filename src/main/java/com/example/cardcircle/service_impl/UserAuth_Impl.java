package com.example.cardcircle.service_impl;

import com.example.cardcircle.Dto.LoginRequest;
import com.example.cardcircle.Dto.RegisterRequest;
import com.example.cardcircle.model.Roles;
import com.example.cardcircle.repository.UserRepository;
import com.example.cardcircle.service.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;

public class UserAuth_Impl implements UserAuth {
    private UserRepository userRepository;


    @Override
    public String CreateUser(RegisterRequest registerRequest) {
        return "";
    }

    @Override
    public String LoginUser(LoginRequest loginRequest) {
        return "";
    }

    @Override
    public String VerifyOtpEmail(String email, String OTP) {
        return "";
    }

    @Override
    public String VerifyOtpEmail(Long PhoneNumber, String OTP) {
        return "";
    }
}
