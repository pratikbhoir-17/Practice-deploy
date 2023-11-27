package com.practiceProject.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practiceProject.Dto.EmployeeDto;
import com.practiceProject.Dto.StatusDto;
import com.practiceProject.model.Employee;
import com.practiceProject.repository.EmployeeRepository;
import com.practiceProject.service.EmployeeService;
import com.practiceProject.util.Constants;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class EmployeeServiceimpl implements EmployeeService {
	@Autowired
	public EmployeeRepository employeeRepo;

	@Override
	public StatusDto addEmp(EmployeeDto emp) {
		log.info("Executing:Employee Service:" + emp);
		Employee employee = new Employee();
		Employee emp1=employeeRepo.findByempId(emp.getEmpId());
		StatusDto response = new StatusDto();
		try {
			if (emp1 != null) {//we can add update APi in this block if we need it
				emp1.setFullName(emp.getFullName());
				emp1.setAddress(emp.getAddress());
				emp1.setPhoneNo(emp.getPhoneNo());
				emp1.setEmpId(emp.getEmpId());
				emp1.setDeletedFlag("False");
				emp1.setJoiningDate(emp.getJoiningDate());
				emp1.setDesignation(emp.getDesignation());
				if(emp.getDesignation()=="HR"||emp.getDesignation()=="Admin") {
					emp1.setRole(0);
				}
				else {
					emp1.setRole(1);
				}
				emp1.setMailId(emp.getMailId());
				employeeRepo.save(emp1);
				response.setCode(Constants.ADSS200);
				response.setMessage(Constants.DETAILS_UPDATED_SUCCESSFULLY);
				
			} else {
				employee.setFullName(emp.getFullName());
				employee.setAddress(emp.getAddress());
				employee.setPhoneNo(emp.getPhoneNo());
				employee.setEmpId(emp.getEmpId());
				employee.setDeletedFlag("False");
				employee.setJoiningDate(emp.getJoiningDate());
				employee.setDesignation(emp.getDesignation());
				if(emp.getDesignation()=="HR"||emp.getDesignation()=="Admin") {
				employee.setRole(0);
				}
				else {
					employee.setRole(1);
				}
				employee.setMailId(emp.getMailId());
				employeeRepo.save(employee);
				response.setCode(Constants.ADSS200);
				response.setMessage(Constants.REGISTERATION_SUCCESSFUL);
			}

		} catch (Exception e) {
			log.error("Error occured inside EmployeeServiceimpl ==> addEmp(): " + e.getMessage());
			response.setCode(Constants.ADSS101);
			response.setMessage("Error occured");
		}
		return response;
	}

}
