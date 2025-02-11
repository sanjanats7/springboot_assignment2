package com.example.springboot_asnmt2.model;

import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Email
    private String email;

    private String role;

    private String department;

    @ManyToMany
    private List<SkillSet> skills;

    @ManyToMany
    private List<Project> projects;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;
}
