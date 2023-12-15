package com.practiceProject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.practiceProject.Dto.EmployeeDto;
import com.practiceProject.Dto.LoginDto;
import com.practiceProject.Dto.StatusDto;
import com.practiceProject.model.Employee;

public interface EmployeeService {
public StatusDto addEmp(EmployeeDto emp);
public List<Employee> findAllEmployee();
public StatusDto removeEmployeeByEmpId(EmployeeDto dto);
public List<Employee> findEmployeeByrole(int role);
public StatusDto login(LoginDto dto);
public StatusDto userApproval(EmployeeDto emp);

}
