package com.example.Reviewers.Repository;

import com.example.Reviewers.Entity.ConferenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<ConferenceEntity, Integer> {
}
