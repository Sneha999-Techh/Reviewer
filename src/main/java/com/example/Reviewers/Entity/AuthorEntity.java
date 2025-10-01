package com.example.Reviewers.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("AUTHOR")
public class AuthorEntity extends PersonEntity {
    private String affiliation;
    private String field;

    public AuthorEntity() {
        super();
    }

    public AuthorEntity(int id, String name, String email, String affiliation, String field) {
        super();
        setId(id);
        setName(name);
        setEmail(email);
        this.affiliation = affiliation;
        this.field = field;
    }

    public String getAffiliation() { return affiliation; }
    public void setAffiliation(String affiliation) { this.affiliation = affiliation; }

    public String getField() { return field; }
    public void setField(String field) { this.field = field; }

    @Override
    public String toString() {
        return "Author [id=" + getId() + ", name=" + getName() + ", email=" + getEmail() + ", affiliation=" + affiliation + ", field=" + field + "]";
    }
}
