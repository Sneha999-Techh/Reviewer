package com.example.Reviewers.Controller;

import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reviewers.Entity.ReviewerEntity;
import com.example.Reviewers.Repository.ReviewerRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Reviewer Management", description = "Operations related to reviewers") 
public class ReviewerController {
    @Autowired
    private ReviewerRepository reviewerRepository;

    @GetMapping("/test")
    @Operation(summary = "Test Method", description = "Returns a greeting message.")
    public String getMethodName() {
        return "Hello Sachin";
    }

    @GetMapping("/api/health")
    @Operation(summary = "Health Check", description = "Returns API health status for frontend testing.")
    public Map<String, Object> healthCheck() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("message", "Backend API is running successfully!");
        response.put("timestamp", new Date());
        return response;
    }

    @GetMapping("/reviewers")
    @Operation(summary = "Get All Reviewers", description = "Retrieves all reviewers.")
    public List<ReviewerEntity> getAllReviewers() {
        return reviewerRepository.findAllByOrderByIdAsc();
    }

    @GetMapping("/reviewers/{id}")
    @Operation(summary = "Get Reviewer by ID", description = "Retrieves a reviewer by their ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful retrieval"),
        @ApiResponse(responseCode = "404", description = "Reviewer not found")
    })
    public ReviewerEntity getReviewerById(@PathVariable("id") Integer id) {
        return reviewerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reviewer with id " + id + " not found"));
    }

    @PostMapping("/reviewers")
    @Operation(summary = "Create Reviewer", description = "Creates a new reviewer.")
    public ResponseEntity<?> createReviewer(@RequestBody ReviewerEntity reviewer) {
        if (reviewer.getName() == null || reviewer.getName().trim().isEmpty() ||
            reviewer.getEmail() == null || reviewer.getEmail().trim().isEmpty() ||
            reviewer.getAffiliation() == null || reviewer.getAffiliation().trim().isEmpty() ||
            reviewer.getExpertise() == null || reviewer.getExpertise().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("All fields (name, email, affiliation, expertise) are required.");
        }
        ReviewerEntity saved = reviewerRepository.save(reviewer);
        return ResponseEntity.ok(saved);
    }

    // Removed ambiguous update endpoint to prevent accidental creation on edit

    @PutMapping("/reviewers/{id}")
    @Operation(summary = "Full Update Reviewer", description = "Replaces an existing reviewer by their ID.")
    public ResponseEntity<?> updateReviewer(@PathVariable("id") int id, @RequestBody ReviewerEntity reviewer) {
        Optional<ReviewerEntity> existingReviewerOpt = reviewerRepository.findById(id);
        if (!existingReviewerOpt.isPresent()) {
            return ResponseEntity.status(404).body("Reviewer with id " + id + " not found");
        }
        ReviewerEntity existingReviewer = existingReviewerOpt.get();
        // Validate payload
        if (reviewer.getName() == null || reviewer.getName().trim().isEmpty() ||
            reviewer.getEmail() == null || reviewer.getEmail().trim().isEmpty() ||
            reviewer.getAffiliation() == null || reviewer.getAffiliation().trim().isEmpty() ||
            reviewer.getExpertise() == null || reviewer.getExpertise().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("All fields (name, email, affiliation, expertise) are required.");
        }
        // Update fields
        existingReviewer.setName(reviewer.getName());
        existingReviewer.setEmail(reviewer.getEmail());
        existingReviewer.setAffiliation(reviewer.getAffiliation());
        existingReviewer.setExpertise(reviewer.getExpertise());
        ReviewerEntity saved = reviewerRepository.save(existingReviewer);
        return ResponseEntity.ok(saved);
    }

    @PatchMapping("/reviewers/{id}")
    @Operation(summary = "Partial Update Reviewer", description = "Updates specific fields of an existing reviewer.")
    public ReviewerEntity patchReviewer(@PathVariable("id") int id, @RequestBody Map<String, Object> updates) {
        Optional<ReviewerEntity> existingReviewerOptional = reviewerRepository.findById(id);
        if (existingReviewerOptional.isPresent()) {
            ReviewerEntity existingReviewer = existingReviewerOptional.get();
            updates.forEach((key, value) -> {
                switch (key) {
                    case "name":
                        existingReviewer.setName((String) value);
                        break;
                    case "email":
                        existingReviewer.setEmail((String) value);
                        break;
                    case "affiliation":
                        existingReviewer.setAffiliation((String) value);
                        break;
                    case "expertise":
                        existingReviewer.setExpertise((String) value);
                        break;
                }
            });
            return reviewerRepository.save(existingReviewer);
        } else {
            throw new RuntimeException("Reviewer with id " + id + " not found");
        }
    }

    @DeleteMapping("/reviewers/{id}")
    @Operation(summary = "Delete Reviewer by ID", description = "Deletes a reviewer by their ID.")
    public ResponseEntity<Void> deleteReviewerById(@PathVariable("id") int id) {
        reviewerRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}