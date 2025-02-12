package com.example.springboot_asnmt2.repository;

import com.example.springboot_asnmt2.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
