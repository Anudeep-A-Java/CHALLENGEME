package com.challengeme.backend.controller;

import com.challengeme.backend.model.User;
import com.challengeme.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> loginData) {
    String email = loginData.get("email");
    String password = loginData.get("password");

    return userRepository.findByEmail(email)
        .filter(user -> user.getPassword().equals(password))
        .map(user -> ResponseEntity.ok(Collections.singletonMap("token", "dummy-jwt-token")))
        .orElse(ResponseEntity.status(401).body(Collections.singletonMap("error", "Invalid credentials")));
}


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String password = body.get("password");

        if (userRepository.findByEmail(email).isPresent()) {
            return ResponseEntity.status(400).body("Email already exists");
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(password); // store as plaintext for now
        userRepository.save(user);

        return ResponseEntity.ok(Collections.singletonMap("message", "User registered successfully"));
    }
}
