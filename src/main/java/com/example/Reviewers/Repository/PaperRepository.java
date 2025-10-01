package com.example.Reviewers.Repository;

import com.example.Reviewers.Entity.PaperEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaperRepository extends JpaRepository<PaperEntity, Integer> {
}
