package com.example.back.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.entities.Employee;
import com.example.back.repositories.EmployeeRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employees")
public class EmployeesController {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeesController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> employees = (List<Employee>) this.employeeRepository.findAll();
		return new ResponseEntity<List<Employee>>(
				employees,
				HttpStatus.OK
				);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getSeanceById(@PathVariable Long id) {
		Employee s = this.employeeRepository.findById(id).orElse(null);
		if(s != null) {
			return new ResponseEntity<Employee>(s, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee e) {
		e = this.employeeRepository.save(e);
		System.out.println("Employee created " + e.getId());
		return new ResponseEntity<Employee>(
				e,
				HttpStatus.CREATED
			);
	}
	
	@PutMapping
	public ResponseEntity<Employee> updateSeance(@RequestBody Employee e) {
		if(this.employeeRepository.existsById(e.getId())) {
			this.employeeRepository.save(e);
	        return new ResponseEntity<Employee>(e, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSeance(@PathVariable Long id) {
		Employee e = this.employeeRepository.findById(id).orElse(null);
		if(e != null) {
			this.employeeRepository.delete(e);
	        return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
}
