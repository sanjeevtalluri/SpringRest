package com.nt.webservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nt.webservices.beans.Employee;

@Component
public class EmployeeDAO {
	private static List<Employee> employeesList=new ArrayList<Employee>();
	private static int count=4;
	static {
		Employee e1= new Employee(1,"waugh");
		Employee e2= new Employee(2, "steve");
		Employee e3= new Employee(3, "sachin");
		Employee e4= new Employee(4, "virat");
		employeesList.add(e1);
		employeesList.add(e2);
		employeesList.add(e3);
		employeesList.add(e4);
		
	}
	public List<Employee> getAll(){
		return employeesList;
	}
	public Employee getOne(Integer id) {
		
		for(int i=0;i<count;i++) {
			if(employeesList.get(i).getId()==id) {
				return employeesList.get(i);
			}
		}
		return null;
	}
	public Employee save(Employee emp) {
		if(emp.getId()==null) {
			emp.setId(++count);
		}
		employeesList.add(emp);
		return emp;
	}

}
