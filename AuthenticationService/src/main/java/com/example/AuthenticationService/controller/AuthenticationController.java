package com.example.AuthenticationService.controller;


import com.example.AuthenticationService.entity.User;
import com.example.AuthenticationService.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        if (authenticate(user)) {
            return ResponseEntity.ok("Authenticated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }

    private boolean authenticate(User user) {
        String s = user.getUsername();
        Optional<User> dbUser = authenticationService.findByUsername(user.getUsername());
        return dbUser.filter(value -> value.getUsername().equals(user.getUsername()) &&
                value.getPassword().equals(user.getPassword())).isPresent();
    }
}
