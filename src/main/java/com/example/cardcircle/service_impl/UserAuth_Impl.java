package com.example.cardcircle.service_impl;

import com.example.cardcircle.Dto.AuthResponse;
import com.example.cardcircle.Dto.LoginRequest;
import com.example.cardcircle.Dto.RegisterRequest;
import com.example.cardcircle.Dto.UserResponse;
import com.example.cardcircle.model.Roles;
import com.example.cardcircle.model.User;
import com.example.cardcircle.repository.UserRepository;
import com.example.cardcircle.service.CustomUserDetailsService;
import com.example.cardcircle.service.JwtService;
import com.example.cardcircle.service.UserAuth;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;


@Service
public class UserAuth_Impl implements UserAuth {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;

    public UserAuth_Impl(UserRepository userRepository,
                         PasswordEncoder passwordEncoder,
                         JwtService jwtService,
                         CustomUserDetailsService customUserDetailsService ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.customUserDetailsService = customUserDetailsService;
    }


    @Override
    public UserResponse CreateUser(RegisterRequest registerRequest) {
        if (userRepository.existsByUsername(registerRequest.username())
                || userRepository.existsByEmail(registerRequest.email())) {

            return new UserResponse<>(
                    false,
                    "User already exists. Please login.",
                    null,
                    Instant.now()
            );
        }

        User user = new User();
        user.setRole(Roles.USER);
        user.setName(registerRequest.name());
        user.setEmail(registerRequest.email());
        user.setUsername(registerRequest.username());
        user.setPassword(passwordEncoder.encode(registerRequest.password()));
        user.setPhoneNumber(registerRequest.phoneNumber());
        user.setRole(Roles.USER);
        User savedUser = userRepository.save(user);

        return new UserResponse<>(
                true,
                "User created successfully.",
                savedUser,
                Instant.now()
        );
    }

    @Override
    public AuthResponse LoginUser(LoginRequest loginRequest) {

        if(!userRepository.existsByUsername(loginRequest.username())){
            throw new RuntimeException("Username does not exist");
        }
        User user = userRepository.findByUsername(loginRequest.username());
        if(!passwordEncoder.matches(loginRequest.password(),user.getPassword())){
            throw new RuntimeException("Invalid password");

        }

        var userDetails = customUserDetailsService.loadUserByUsername(user.getUsername());
        String token = jwtService.generateToken(userDetails);
        return new AuthResponse(token);
    }


}
