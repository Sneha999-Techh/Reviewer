package com.example.Reviewers.Controller;

import com.example.Reviewers.Entity.ConferenceEntity;
import com.example.Reviewers.Repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conferences")
public class ConferenceController {
    @Autowired
    private ConferenceRepository conferenceRepository;

    @GetMapping
    public List<ConferenceEntity> getAllConferences() {
        return conferenceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ConferenceEntity getConference(@PathVariable int id) {
        return conferenceRepository.findById(id).orElse(null);
    }
}
