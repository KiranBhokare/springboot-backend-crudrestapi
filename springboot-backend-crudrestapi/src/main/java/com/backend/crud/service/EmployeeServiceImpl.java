package com.backend.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.crud.entity.Employee;
import com.backend.crud.exception.MycustomException;
import com.backend.crud.exception.ResourceNotFoundException;
import com.backend.crud.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
      @Autowired
	 EmployeeRepository empRepository;
	
	
//	public boolean addEmployee(Employee emp)
//	{
//		 empRepository.save(emp);
//		 return true;
//		 
//	}
	
	public Employee addEmployee(Employee emp)
	{
		return empRepository.save(emp);		 	 
	}
	
	public List<Employee> getAllEmployees()
	{
		return empRepository.findAll();
	}
	

	public Employee getEmployeeById(int id)
	{
		
	 Optional<Employee>emp  =empRepository.findById(id);
	 
	 //we   are going to check whether the employee with given id is present or not  in the database  
	 
	 if(emp.isPresent())
	 {
		 return emp.get();
	 }
		
	 else
	 {
		 throw new ResourceNotFoundException("Employee", "Id" , id);
		 
		// throw new MycustomException("Employee not Found of id ..." +id);
	 }
	}
	
	
//	//////****************************************************////
	
	public Employee updateEmployee(Employee emp , int id)
	{   
		//we   are going to check whether the employee with given id is present or not  in the database      //resourcename-fieldname-fieldvalue
		Employee existingemp  = empRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id",id));
		
		existingemp.setFirstName(emp.getFirstName());
		existingemp.setLastName(emp.getLastName());
		existingemp.setEmail(emp.getEmail());
		
		//saving existing employee to database
		empRepository.save(existingemp);
		
		return existingemp;
	}
//	
//	////**********************************************************////
//	
//	public boolean deleteEmployee(int id)
//	{
//		
//		//check employee exists in the database or not
//		
//		  empRepository.findById(id).orElseThrow(()->new MycustomException("Resource not found please correct it"+id));
//	
//	      empRepository.deleteById(id);
//	      
//	      return true;
//	}

	
	public Employee deleteEmployee(int id)
	{
		
		//check employee exists in the database or not
		
		 Employee employee =  empRepository.findById(id).orElseThrow(()->new MycustomException("Employee not found please correct for id "+id));
	
	      empRepository.deleteById(id);
	      
	      return employee;
	}
	
	
	
	
	
	
	
	
	
	
	
}
