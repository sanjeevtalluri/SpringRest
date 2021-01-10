package com.nt.webservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.webservices.beans.Employee;

@RestController
public class Controller {
	@GetMapping(path = "/employee")
	public Employee getEmployee() {
		System.out.println("Controller.getEmployee()");
		return new Employee("mark");
	}

}
