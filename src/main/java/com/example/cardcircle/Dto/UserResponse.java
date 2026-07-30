package com.example.cardcircle.Dto;

import java.time.Instant;

public record UserResponse<T>(boolean success,
                           String message,
                           T data,
                           Instant timestamp) {


}
