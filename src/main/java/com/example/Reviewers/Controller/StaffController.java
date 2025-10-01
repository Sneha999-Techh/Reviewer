package com.example.Reviewers.Controller;

import com.example.Reviewers.Entity.StaffEntity;
import com.example.Reviewers.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffRepository staffRepository;

    @GetMapping
    public List<StaffEntity> getAllStaff() {
        return staffRepository.findAll();
    }

    @PostMapping
    public StaffEntity createStaff(@RequestBody StaffEntity staff) {
        return staffRepository.save(staff);
    }
}
