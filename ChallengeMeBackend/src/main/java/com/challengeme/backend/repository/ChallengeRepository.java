package com.challengeme.backend.repository;

import com.challengeme.backend.model.Challenge;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChallengeRepository extends MongoRepository<Challenge, String> {}
