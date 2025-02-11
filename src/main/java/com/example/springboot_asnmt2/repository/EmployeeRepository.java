package com.example.springboot_asnmt2.repository;

import com.example.springboot_asnmt2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
