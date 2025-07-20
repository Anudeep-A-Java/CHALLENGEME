package com.challangme.challangme_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/api/health")
    public String healthCheck() {
        return "✅ ChallangMe backend is running!";
    }
}
