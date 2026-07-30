package com.example.cardcircle.Dto;

import com.example.cardcircle.model.Roles;

public record RegisterRequest(String name, String email
        , String UserName,String Password
        , Long PhoneNumber, Roles role) {

}
