package com.example.Reviewers.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "profiles")
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bio;
    private String phone;
    private String address;

    @OneToOne
    @JoinColumn(name = "reviewer_id", referencedColumnName = "id")
    @com.fasterxml.jackson.annotation.JsonBackReference
    private ReviewerEntity reviewer;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public ReviewerEntity getReviewer() { return reviewer; }
    public void setReviewer(ReviewerEntity reviewer) { this.reviewer = reviewer; }
}
