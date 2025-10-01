package com.example.Reviewers.Controller;

import com.example.Reviewers.Entity.ProfileEntity;
import com.example.Reviewers.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping
    public List<ProfileEntity> getAllProfiles() {
        return profileRepository.findAll();
    }

    @PostMapping
    public ProfileEntity createProfile(@RequestBody ProfileEntity profile) {
        return profileRepository.save(profile);
    }

    @GetMapping("/{id}")
    public ProfileEntity getProfile(@PathVariable int id) {
        return profileRepository.findById(id).orElse(null);
    }
}
