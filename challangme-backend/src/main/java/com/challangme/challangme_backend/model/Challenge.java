package com.challangme.challangme_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "challenges")
public class Challenge {

    @Id
    private String id;

    private String title;
    private String description;
    private String createdBy;
    private LocalDateTime createdAt;

    public Challenge() {}

    public Challenge(String title, String description, String createdBy, LocalDateTime createdAt) {
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public String getId() { return id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getCreatedBy() { return createdBy; }

    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
