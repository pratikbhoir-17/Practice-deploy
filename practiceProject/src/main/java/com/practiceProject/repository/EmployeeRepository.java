package com.practiceProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practiceProject.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public Employee findByempId(String empId); 

}
