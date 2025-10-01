package com.example.Reviewers.Repository;

import com.example.Reviewers.Entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer> {
}
