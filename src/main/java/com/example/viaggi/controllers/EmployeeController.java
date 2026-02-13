package com.example.viaggi.controllers;

import com.example.viaggi.entities.Employee;
import com.example.viaggi.repositories.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import com.cloudinary.Cloudinary;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Map;



@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final Cloudinary cloudinary;

    public EmployeeController(EmployeeRepository employeeRepository,  Cloudinary cloudinary) {
        this.employeeRepository = employeeRepository;
        this.cloudinary = cloudinary;
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
    @PostMapping("/{id}/upload")
    public Employee uploadImage(@PathVariable UUID id,
                                @RequestParam("file") MultipartFile file) throws IOException {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dipendente non trovato"));

        Map result = cloudinary.uploader().upload(file.getBytes(), Map.of());

        String imageUrl = result.get("url").toString();

        employee.setImmagineProfilo(imageUrl);

        return employeeRepository.save(employee);
    }


}
