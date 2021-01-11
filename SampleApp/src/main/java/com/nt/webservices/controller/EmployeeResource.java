package com.nt.webservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.webservices.UserExceptions.EmployeeNotFoundException;
import com.nt.webservices.beans.Employee;
import com.nt.webservices.dao.EmployeeDAO;

@RestController
public class EmployeeResource {
	@Autowired
	private EmployeeDAO dao;
	
	@GetMapping(path = "/employees")
	public List<Employee> getEmployees() {
		return dao.getAll();
	}
	
	@GetMapping(path = "/employees/{id}")
	public Employee getEmployee(@PathVariable int id) {
		Employee emp=dao.getOne(id);
		if(emp==null) {
			throw new EmployeeNotFoundException("id: "+id);
		}
		return emp;
	}
	
	@PostMapping(path="/employees")
	public void saveEmployee(@RequestBody Employee emp) {
		Employee employee=dao.save(emp);
		
	}

}
