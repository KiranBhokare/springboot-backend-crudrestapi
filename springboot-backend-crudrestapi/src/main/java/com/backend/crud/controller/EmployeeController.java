package com.backend.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.crud.entity.Employee;
import com.backend.crud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController 
{
    @Autowired
	EmployeeService empservice;   
	
	
//	@PostMapping("/addemployee")
//	public ResponseEntity<?> addEmployee(@RequestBody Employee emp)
//	{
//		 System.out.println("project started");
//		 boolean res=  empservice.addEmployee(emp);
//		 
//		 if (res)
//		 {
//			return ResponseEntity.ok("congrats record saved sucessfully");
//			 
//		 }
//		 else
//		 {
//			 return ResponseEntity.ok("record not saved sucessfully");
//		 }
//	}	 		 
	
	
//	 Approach 2 -- return type Employee should be in service & serviceImpl class----here return type is  ResponseEntity<Employee>
	 @PostMapping("/addemployee")
	 public  ResponseEntity<Employee> addEmployee(@RequestBody Employee emp)
	 {
		 Employee employee = empservice.addEmployee(emp);
		 
		 ResponseEntity<Employee> re = new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
		 
		 return re;
		 	 
	 }

	//********************************//
	
	 @GetMapping("/employees")
	 public List<Employee> getAllEmployees()
	 {
		 return empservice.getAllEmployees();
     }
	
	 
	 @GetMapping("/employees/employee/{id}")
	 public ResponseEntity<Employee> getEmployeesById(@PathVariable("id")int empid)
	 {
		 Employee employee = empservice.getEmployeeById(empid);
		 
		 ResponseEntity<Employee> re = new ResponseEntity<>(employee, HttpStatus.OK);
		                                                  // body      HttpStatus  
		 return re;
		 
	 }
	 
	 @PutMapping("/employee/{id}")
	 public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int empid, @RequestBody Employee emp)
	 { 
		 Employee employee = empservice.updateEmployee(emp,empid);
		 
		 return new ResponseEntity<Employee> (employee,HttpStatus.OK);
	 }
	 
//	 @DeleteMapping("/employee/{id}")
//	 public ResponseEntity<String> deleteEmployee(@PathVariable ("id") int empid)
//	 {
//		   boolean empresult =empservice.deleteEmployee(empid);
//		 
//		   if(empresult)
//		   {
//			  return  ResponseEntity.ok("Congrats Record deleted sucessfully");
//		   }
//			   
//		   else
//		   {
//			   return ResponseEntity.ok("record not deleted");
//		   }
//	  }	   
			 
	 @DeleteMapping("/employee/{id}")
	 public ResponseEntity<Employee> deleteEmployee(@PathVariable ("id") int empid)
	 {
		     Employee empresult = empservice.deleteEmployee(empid);
		 
		   
			 ResponseEntity<Employee> re = new ResponseEntity<>(empresult, HttpStatus.OK);
			                                                  // body      HttpStatus  
			 return re;
		  
	  }	   
	 
	 



}
	
