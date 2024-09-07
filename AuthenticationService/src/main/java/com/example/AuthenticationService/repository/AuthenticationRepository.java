package com.example.AuthenticationService.repository;

import com.example.AuthenticationService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthenticationRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
