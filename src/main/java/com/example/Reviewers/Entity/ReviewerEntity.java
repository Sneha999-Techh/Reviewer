
package com.example.Reviewers.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;

@Entity
@DiscriminatorValue("REVIEWER")
public class ReviewerEntity extends PersonEntity {
    @ManyToMany
    @JoinTable(
        name = "reviewer_conference",
        joinColumns = @JoinColumn(name = "reviewer_id"),
        inverseJoinColumns = @JoinColumn(name = "conference_id")
    )
    private java.util.Set<ConferenceEntity> conferences;

    public java.util.Set<ConferenceEntity> getConferences() { return conferences; }
    public void setConferences(java.util.Set<ConferenceEntity> conferences) { this.conferences = conferences; }
    @OneToMany(mappedBy = "reviewer", cascade = CascadeType.ALL)
    @com.fasterxml.jackson.annotation.JsonManagedReference
    private java.util.List<PaperEntity> papers;

    public java.util.List<PaperEntity> getPapers() { return papers; }
    public void setPapers(java.util.List<PaperEntity> papers) { this.papers = papers; }
    @OneToOne(mappedBy = "reviewer", cascade = CascadeType.ALL)
    @com.fasterxml.jackson.annotation.JsonManagedReference
    private ProfileEntity profile;

    public ProfileEntity getProfile() { return profile; }
    public void setProfile(ProfileEntity profile) { this.profile = profile; }
    public void setId(int id) {
    setId(id);
    }
    private String affiliation;
    private String expertise;

    // Default constructor
    public ReviewerEntity() {
        super();
    }

    // Parameterized constructor
    public ReviewerEntity(int id, String name, String email, String affiliation, String expertise) {
        super();
        setId(id);
        setName(name);
        setEmail(email);
        this.affiliation = affiliation;
        this.expertise = expertise;
    }

    // Getters and setters for new fields
    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    @Override
    public String toString() {
        return "Reviewer [id=" + getId() + 
               ", name=" + getName() + 
               ", email=" + getEmail() + 
               ", affiliation=" + affiliation + 
               ", expertise=" + expertise + "]";
    }
}