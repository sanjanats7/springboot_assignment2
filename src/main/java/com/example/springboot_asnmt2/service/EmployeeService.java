package com.example.springboot_asnmt2.service;

import com.example.springboot_asnmt2.dto.EmployeeDTO;
import com.example.springboot_asnmt2.exception.ResourceNotFoundException;
import com.example.springboot_asnmt2.model.Employee;
import com.example.springboot_asnmt2.model.Project;
import com.example.springboot_asnmt2.model.SkillSet;
import com.example.springboot_asnmt2.model.Employer;
import com.example.springboot_asnmt2.repository.EmployeeRepository;
import com.example.springboot_asnmt2.repository.ProjectRepository;
import com.example.springboot_asnmt2.repository.SkillSetRepository;
import com.example.springboot_asnmt2.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SkillSetRepository skillSetRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployerRepository employerRepository;

    public Employee addEmployee(EmployeeDTO employeeDTO) {
        Employer employer = employerRepository.findById(employeeDTO.getEmployerId())
                .orElseThrow(() -> new ResourceNotFoundException("Employer not found"));

        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setRole(employeeDTO.getRole());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setEmployer(employer);

        List<SkillSet> skills = skillSetRepository.findAllById(employeeDTO.getSkillIds());
        List<Project> projects = projectRepository.findAllById(employeeDTO.getProjectIds());

        employee.setSkills(skills);
        employee.setProjects(projects);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long employeeId, EmployeeDTO employeeDTO) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            Employer employer = employerRepository.findById(employeeDTO.getEmployerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Employer not found"));

            employee.setName(employeeDTO.getName());
            employee.setEmail(employeeDTO.getEmail());
            employee.setRole(employeeDTO.getRole());
            employee.setDepartment(employeeDTO.getDepartment());
            employee.setEmployer(employer);

            List<SkillSet> skills = skillSetRepository.findAllById(employeeDTO.getSkillIds());
            List<Project> projects = projectRepository.findAllById(employeeDTO.getProjectIds());

            employee.setSkills(skills);
            employee.setProjects(projects);
            return employeeRepository.save(employee);
        }
        throw new ResourceNotFoundException("Employee not found");
    }

    public void removeEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }
}
