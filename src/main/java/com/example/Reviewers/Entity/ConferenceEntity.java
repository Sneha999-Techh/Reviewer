package com.example.Reviewers.Entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "conferences")
public class ConferenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String location;
    private String date;

    @ManyToMany(mappedBy = "conferences")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Set<ReviewerEntity> reviewers;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public Set<ReviewerEntity> getReviewers() { return reviewers; }
    public void setReviewers(Set<ReviewerEntity> reviewers) { this.reviewers = reviewers; }
}
