package com.challangme.challangme_backend.repository;

import com.challangme.challangme_backend.model.Challenge;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChallengeRepository extends MongoRepository<Challenge, String> {}
