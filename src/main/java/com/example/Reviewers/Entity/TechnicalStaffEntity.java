package com.example.Reviewers.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("TECHNICAL")
public class TechnicalStaffEntity extends StaffEntity {
    private String skill;

    public String getSkill() { return skill; }
    public void setSkill(String skill) { this.skill = skill; }
}
