package com.example.Reviewers;

import com.example.Reviewers.Entity.ProfileEntity;
import com.example.Reviewers.Entity.ReviewerEntity;
import com.example.Reviewers.Entity.AuthorEntity;
import com.example.Reviewers.Repository.ProfileRepository;
import com.example.Reviewers.Entity.PaperEntity;
import com.example.Reviewers.Repository.PaperRepository;
import com.example.Reviewers.Entity.ConferenceEntity;
import com.example.Reviewers.Repository.ConferenceRepository;
import com.example.Reviewers.Repository.ReviewerRepository;
import com.example.Reviewers.Repository.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.Reviewers.Entity.StaffEntity;
import com.example.Reviewers.Entity.AdminStaffEntity;
import com.example.Reviewers.Entity.TechnicalStaffEntity;
import com.example.Reviewers.Repository.StaffRepository;

@Configuration
public class SampleDataConfig {
    @Bean
    public CommandLineRunner loadSampleData(ReviewerRepository reviewerRepository, ProfileRepository profileRepository, PaperRepository paperRepository, ConferenceRepository conferenceRepository, AuthorRepository authorRepository, StaffRepository staffRepository) {
            // Sample Author
            AuthorEntity author = new AuthorEntity();
            author.setName("Test Author");
            author.setEmail("author@example.com");
            author.setAffiliation("Author University");
            author.setField("Computer Science");

        return args -> {
            // StaffEntity single table inheritance sample data
            AdminStaffEntity admin = new AdminStaffEntity();
            admin.setName("Admin Staff");
            admin.setEmail("admin@staff.com");
            admin.setDepartment("HR");
            staffRepository.save(admin);

            TechnicalStaffEntity tech = new TechnicalStaffEntity();
            tech.setName("Tech Staff");
            tech.setEmail("tech@staff.com");
            tech.setSkill("Networking");
            staffRepository.save(tech);
            ReviewerEntity reviewer = new ReviewerEntity();
            reviewer.setName("Test Reviewer");
            reviewer.setEmail("test@example.com");
            reviewer.setExpertise("AI");
            reviewer.setAffiliation("Test University");

            ProfileEntity profile = new ProfileEntity();
            profile.setBio("This is a test bio.");
            profile.setPhone("1234567890");
            profile.setAddress("123 Test St, Test City");
            profile.setReviewer(reviewer);
            reviewer.setProfile(profile);

            PaperEntity paper1 = new PaperEntity();
            paper1.setTitle("AI in Healthcare");
            paper1.setAbstractText("Exploring AI applications in healthcare.");
            paper1.setStatus("Accepted");
            paper1.setReviewer(reviewer);

            PaperEntity paper2 = new PaperEntity();
            paper2.setTitle("Machine Learning Basics");
            paper2.setAbstractText("Introduction to ML concepts.");
            paper2.setStatus("Under Review");
            paper2.setReviewer(reviewer);

            java.util.List<PaperEntity> papers = new java.util.ArrayList<>();
            papers.add(paper1);
            papers.add(paper2);
            reviewer.setPapers(papers);

            ConferenceEntity conf1 = new ConferenceEntity();
            conf1.setName("Spring Boot Summit");
            conf1.setLocation("New York");
            conf1.setDate("2025-10-01");

            ConferenceEntity conf2 = new ConferenceEntity();
            conf2.setName("AI World Congress");
            conf2.setLocation("London");
            conf2.setDate("2025-11-15");

            java.util.Set<ConferenceEntity> conferences = new java.util.HashSet<>();
            conferences.add(conf1);
            conferences.add(conf2);
            reviewer.setConferences(conferences);

            java.util.Set<ReviewerEntity> reviewers = new java.util.HashSet<>();
            reviewers.add(reviewer);
            conf1.setReviewers(reviewers);
            conf2.setReviewers(reviewers);

            conferenceRepository.save(conf1);
            conferenceRepository.save(conf2);
            reviewerRepository.save(reviewer);
            authorRepository.save(author);
        };
    }
}
