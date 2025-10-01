package com.example.Reviewers.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class AdminStaffEntity extends StaffEntity {
    private String department;

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
}
