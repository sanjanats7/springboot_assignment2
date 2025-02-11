package com.example.springboot_asnmt2.service;

import com.example.springboot_asnmt2.model.Employer;
import com.example.springboot_asnmt2.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    public Employer createEmployer(Employer employer) {
        return employerRepository.save(employer);
    }
}
