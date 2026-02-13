package com.example.viaggi.controllers;

import com.example.viaggi.entities.Employee;
import com.example.viaggi.repositories.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // CREATE
    @PostMapping
    public Employee createEmployee(@RequestBody @Valid Employee employee) {
        return employeeRepository.save(employee);
    }

    // READ ALL
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable UUID id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dipendente non trovato"));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable UUID id) {
        employeeRepository.deleteById(id);
    }
}
