package com.backend.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee , Integer>
{
    
}
