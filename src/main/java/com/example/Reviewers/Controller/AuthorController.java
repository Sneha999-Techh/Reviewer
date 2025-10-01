package com.example.Reviewers.Controller;

import com.example.Reviewers.Entity.AuthorEntity;
import com.example.Reviewers.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.findAll();
    }

    @PostMapping
    public AuthorEntity createAuthor(@RequestBody AuthorEntity author) {
        return authorRepository.save(author);
    }

    @GetMapping("/{id}")
    public AuthorEntity getAuthorById(@PathVariable int id) {
        return authorRepository.findById(id).orElse(null);
    }
}
