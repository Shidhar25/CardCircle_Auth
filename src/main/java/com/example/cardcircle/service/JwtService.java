package com.example.cardcircle.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    private final String secret;
    private final long expirationMs;

    public JwtService(@Value("${app.jwt.secret}") String secret,
                      @Value("${app.jwt.expiration-ms}") long expirationMs) {
        this.secret = secret;
        this.expirationMs = expirationMs;
    }

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(UserDetails userDetails){

        return Jwts.builder()

                .subject(userDetails.getUsername())

                .issuedAt(new Date())

                .expiration(new Date(System.currentTimeMillis()+expirationMs))

                .signWith(getKey())

                .compact();

    }

    public String extractUsername(String token){

        return Jwts.parser()

                .verifyWith(getKey())

                .build()
                .parseSignedClaims(token)

                .getPayload()

                .getSubject();
    }

    public boolean isTokenValid(String token,UserDetails user){

        return extractUsername(token).equals(user.getUsername());

    }

}
