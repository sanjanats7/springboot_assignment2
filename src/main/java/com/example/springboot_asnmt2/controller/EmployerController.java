package com.example.springboot_asnmt2.controller;

import com.example.springboot_asnmt2.model.Employer;
import com.example.springboot_asnmt2.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @PostMapping
    public Employer createEmployer(@RequestBody Employer employer) {
        return employerService.createEmployer(employer);
    }
}
