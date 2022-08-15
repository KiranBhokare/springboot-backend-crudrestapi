package com.backend.crud.service;

import java.util.List;

import com.backend.crud.entity.Employee;

public interface EmployeeService 
{

	//public boolean addEmployee(Employee emp);
	
	public Employee addEmployee(Employee emp);
	
	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(int id);

	public Employee updateEmployee(Employee emp, int id);
	
//	public boolean deleteEmployee(int id);
	
    public Employee deleteEmployee(int id);
 	
}
