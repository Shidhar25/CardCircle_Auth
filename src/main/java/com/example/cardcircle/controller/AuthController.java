package com.example.cardcircle.controller;

import com.example.cardcircle.Dto.AuthResponse;
import com.example.cardcircle.Dto.LoginRequest;
import com.example.cardcircle.Dto.RegisterRequest;
import com.example.cardcircle.Dto.UserResponse;
import com.example.cardcircle.service_impl.UserAuth_Impl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserAuth_Impl userAuth;



    public AuthController(UserAuth_Impl userAuth) {
        this.userAuth = userAuth;
    }

    @GetMapping("/check")
    public String check(){
        return "Working";
    }
    @PostMapping("/register")
    public ResponseEntity<UserResponse> addUser(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(userAuth.CreateUser(registerRequest));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginUser(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(userAuth.LoginUser(loginRequest));
    }
}
