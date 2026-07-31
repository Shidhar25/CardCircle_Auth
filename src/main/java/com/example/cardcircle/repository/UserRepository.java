package com.example.cardcircle.repository;

import com.example.cardcircle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String Username);
    User findByEmail(String Email);
    User findByPhoneNumber(Long PhoneNumber);

    boolean existsByUsername(String Username);

    boolean existsByEmail(String Email);
}
