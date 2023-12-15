package com.practiceProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practiceProject.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public List<Employee> findByempId(String empId); 
	public List<Employee> findByrole(int role);
	public Employee findBymailId(String mailId);
	public Employee findBymailIdAndPassword(String mailId, String password);

}
