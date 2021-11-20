package com.full.stack.controller;

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

import com.full.stack.entity.Employee;
import com.full.stack.repository.EmployeeRepo;


@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepo er;
	
	@GetMapping("/employees")
	public List<Employee> getEmployeess()
	{
	   return er.findAll();
	}
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable Long id)
	{
		return er.findById(id).get();
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		er.save(employee);
	  return employee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		return er.save(employee);
		
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id)
	{
		er.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}

}
