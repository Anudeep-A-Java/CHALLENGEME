package com.challangme.challangme_backend.controller;

import com.challangme.challangme_backend.model.Challenge;
import com.challangme.challangme_backend.repository.ChallengeRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/challenges")
public class ChallengeController {

    private final ChallengeRepository challengeRepo;

    public ChallengeController(ChallengeRepository challengeRepo) {
        this.challengeRepo = challengeRepo;
    }

    @PostMapping
    public Challenge createChallenge(@RequestBody Challenge challenge) {
        challenge.setCreatedAt(LocalDateTime.now());
        return challengeRepo.save(challenge);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Challenge> getChallengeById(@PathVariable String id) {
        Optional<Challenge> challenge = challengeRepo.findById(id);
        return challenge.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
