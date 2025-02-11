package com.example.springboot_asnmt2.repository;

import com.example.springboot_asnmt2.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
