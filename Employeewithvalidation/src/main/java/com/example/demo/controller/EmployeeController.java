package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.service.myserive;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeController {

    @Autowired
    private myserive service;

    // Get all employees
    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee() {
        return service.getAllEmployee();
    }

    // Get employee by ID
    @GetMapping("/getEmployee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    // Add employee
    @PostMapping("/addEmployee")
    public String addEmployee(@Valid @RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    // Update employee
    @PutMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable int id,
                                 @Valid @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }

    // Delete employee by ID
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }

    // Delete all employees
    @DeleteMapping("/deleteAllEmployee")
    public String deleteAllEmployee() {
        return service.deleteAllEmployee();
    }
}