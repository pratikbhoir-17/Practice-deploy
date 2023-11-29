package com.practiceProject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import com.practiceProject.Dto.EmployeeDto;
import com.practiceProject.Dto.LoginDto;
import com.practiceProject.Dto.Message;
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
		Employee emp1=employeeRepo.findBymailId(emp.getMailId());
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
				employee.setPassword(emp.getPassword());
				employee.setApprovedFlag("False");
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

	@Override
	public List<Employee> findAllEmployee() {
//		List<EmployeeDto> userDtoList = new ArrayList<>();
//		ListAllUser resultDto = new ListAllUser();
		
		List<Employee> emp1=employeeRepo.findAll();
		return emp1;
	}

	@Override
	public StatusDto removeEmployeeByEmpId(EmployeeDto dto) {
		StatusDto responseDto = new StatusDto();
		Employee employee=null;
		try {
			if (dto.getMailId() != null) {
			  employee = employeeRepo.findBymailId(dto.getMailId());
				if (employee == null) {
					responseDto.setCode("101");
					responseDto.setMessage("Employee Id should not found");

				} else {
					employee.setDeletedFlag("True");
					employeeRepo.save(employee);
					responseDto.setCode("200");
					responseDto.setMessage("Employee Deactiveted");

				}
			} else {
				responseDto.setCode("100");
				responseDto.setMessage("Employee Id should not null");

			}
		} catch (Exception e) {
			//log.error("Error inprojectServiceImpl deactivateProject: {}", e.getMessage());
//			responseDto.setResponseCode(Constants.TSA101);
//			responseDto.setResponseMessage(Constants.INTERNAL_SERVER_ERROR);
            System.out.println(e);
		}
		return responseDto;

	}

	@Override
	public List<Employee> findEmployeeByrole(int role) {
		    try {
		        // Retrieve the list of projects by projectId
		        List<Employee> list = employeeRepo.findByrole(role);
		        return list;
}
		    catch(Exception e) {
		    	System.out.println(e);
		    }
		    return null;
		    
	}

	
}

	
