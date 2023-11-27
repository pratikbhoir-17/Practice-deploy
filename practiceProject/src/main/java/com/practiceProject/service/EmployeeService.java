package com.practiceProject.service;

import java.util.List;

import com.practiceProject.Dto.EmployeeDto;
import com.practiceProject.Dto.StatusDto;
import com.practiceProject.model.Employee;

public interface EmployeeService {
public StatusDto addEmp(EmployeeDto emp);
public List<Employee> findAllEmployee();
public StatusDto removeEmployeeByEmpId(String empId);
public List<Employee> findEmployeeByrole(int role);

}
