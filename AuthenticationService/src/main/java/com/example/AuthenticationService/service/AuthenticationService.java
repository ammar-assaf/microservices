package com.example.AuthenticationService.service;

import com.example.AuthenticationService.entity.User;
import com.example.AuthenticationService.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    public Optional<User> findByUsername(String username)
    {
        return authenticationRepository.findByUsername(username);
    }
}
