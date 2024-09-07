package com.example.ShowResultsService.service;

import com.example.ShowResultsService.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationServiceClient {
    private final RestTemplate restTemplate = new RestTemplate();

    public boolean validateUser(String username, String password) {
        User user = new User(username, password);
//        String url = "http://auth-service:8082/auth/login";
//        String requestBody = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";
//        return restTemplate.postForObject(url, requestBody, String.class);
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(
                    "http://authenticationservice:8080/auth/login", user, String.class);
            return response.getStatusCode() == HttpStatus.OK;
        } catch (HttpClientErrorException e) {
            return false;
        }
    }

}
