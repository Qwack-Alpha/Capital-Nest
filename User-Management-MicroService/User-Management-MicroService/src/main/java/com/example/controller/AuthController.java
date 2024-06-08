package com.example.controller;

import com.example.model.AuthenticationResponse;
import com.example.model.LoginRequest;
import com.example.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        
        // Your authentication logic here
        // Assuming isValidUser method checks email and password against database
        
        if (isValidUser(email, password)) {
            // If valid, generate token and send it back
            String token = usersService.generateToken(email);
            return ResponseEntity.ok(new AuthenticationResponse(token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    // Placeholder method for validating user credentials
    private boolean isValidUser(String email, String password) {
        // Your implementation to validate user credentials (check against database, etc.)
        // For demo purposes, always return true
        return true;
    }
}

