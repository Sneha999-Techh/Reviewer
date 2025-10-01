package com.example.Reviewers.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "papers")
public class PaperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String abstractText;
    private String status;

    @ManyToOne
    @JoinColumn(name = "reviewer_id")
    @com.fasterxml.jackson.annotation.JsonBackReference
    private ReviewerEntity reviewer;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAbstractText() { return abstractText; }
    public void setAbstractText(String abstractText) { this.abstractText = abstractText; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public ReviewerEntity getReviewer() { return reviewer; }
    public void setReviewer(ReviewerEntity reviewer) { this.reviewer = reviewer; }
}
