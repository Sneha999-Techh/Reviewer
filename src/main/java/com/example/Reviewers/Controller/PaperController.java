package com.example.Reviewers.Controller;

import com.example.Reviewers.Entity.PaperEntity;
import com.example.Reviewers.Repository.PaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/papers")
public class PaperController {
    @Autowired
    private PaperRepository paperRepository;

    @GetMapping
    public List<PaperEntity> getAllPapers() {
        return paperRepository.findAll();
    }

    @GetMapping("/{id}")
    public PaperEntity getPaper(@PathVariable int id) {
        return paperRepository.findById(id).orElse(null);
    }
}
