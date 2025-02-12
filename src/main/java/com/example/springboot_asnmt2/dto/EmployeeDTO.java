package com.example.springboot_asnmt2.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private String name;
    private String email;
    private String role;
    private String department;
    private Long employerId;
    private List<Long> skillIds;
    private List<Long> projectIds;
}

