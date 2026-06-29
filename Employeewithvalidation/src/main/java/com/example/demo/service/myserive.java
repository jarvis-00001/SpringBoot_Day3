package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.repository.myrepo;

@Service
public class myserive {
	
	@Autowired
	myrepo repo;
	
	
	public List<Employee> getAllEmployee(){
		return repo.findAll();
	}
	
	public Employee getEmployeeById(int id) {
		return repo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: "+id));
		
	}
	
	public String addEmployee(Employee employee) {
		repo.save(employee);
		return "Employee saved successfully";
	}
	public String updateEmployee(int id, Employee updatedEmployee) {
		Optional<Employee> existingEmp = repo.findById(id);
		if(existingEmp.isPresent()) {
			Employee emp = existingEmp.get();
			emp.setName(updatedEmployee.getName());
			emp.setAge(updatedEmployee.getAge());
			emp.setSalary(updatedEmployee.getSalary());
			emp.setDesignation(updatedEmployee.getDesignation());
			repo.save(emp);
			return "Employee data saves successfully";
			
		}
		else {
			return "Employee not found with id: "+id;
		}
		
	}
	public String deleteEmployee(int id) {
	    if(repo.existsById(id)) {
	        repo.deleteById(id);
	        return "Employee deleted successfully";
	    }
	    else {
	        throw new EmployeeNotFoundException("Employee not found with id: " + id);
	    }
	}
	
	public String deleteAllEmployee() {
		repo.deleteAll();
		return "All employee deleted successfully";
	}
}
