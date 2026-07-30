package com.example.cardcircle.repository;

import com.example.cardcircle.model.User;
import jakarta.jws.soap.SOAPBinding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String Username);
    User findByEmail(String Email);
    User findByPhoneNumber(Long PhoneNumber);
}
