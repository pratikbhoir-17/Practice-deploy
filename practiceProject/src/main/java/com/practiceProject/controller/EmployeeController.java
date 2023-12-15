package com.practiceProject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;
import com.practiceProject.Dto.EmployeeDto;
import com.practiceProject.Dto.LoginDto;
import com.practiceProject.Dto.StatusDto;
import com.practiceProject.model.Employee;
import com.practiceProject.service.EmployeeService;
import com.practiceProject.util.Constants;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidatorFactory;


@RestController

public class EmployeeController {
	@Autowired
	public EmployeeService employeeService;

	@PostMapping("/")
	public String Testing() {
		return "Welcome";

	}
	
	@PostMapping("/login")
	public ResponseEntity<?>login(@RequestBody LoginDto dto) {
		Employee emp = new Employee();
		Logger logger = Logger.getLogger(EmployeeController.class);
		 logger.info("Inside EmployeeController ==> login Api" + dto);
		StatusDto response = new StatusDto();
			try {
				response = employeeService.login(dto);
			} catch (Exception e1) {
				//response.setJwttoken("");
				//response.setStatus(Constants.FAIL);
				response.setCode(Constants.ADSS101);
				response.setMessage(Constants.INVALID_EMAIL);
				//log.error(response);
				// }
			}
		
		
		return ResponseEntity.ok(response);
		
		
	}
	
	@PostMapping("/addEmployee")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto emp) {
		 Logger logger = Logger.getLogger(EmployeeController.class);
		 logger.info("Inside EmployeeController ==> addEmployee() " + emp);
		 List<StatusDto> reslist = new ArrayList<StatusDto>();
		 StatusDto response = new StatusDto();
		ValidatorFactory factory = jakarta.validation.Validation.buildDefaultValidatorFactory();
		jakarta.validation.Validator validator = factory.getValidator();
		Set<ConstraintViolation<EmployeeDto>> violations = validator.validate(emp);
		for (ConstraintViolation<EmployeeDto> violation : violations) {
			response.setCode(Constants.ADSS100);
			response.setMessage(violation.getMessage());
			reslist.add(response);
			logger.error(violations);
			return ResponseEntity.ok(reslist);
		}
		if (reslist.isEmpty()) {
		response=employeeService.addEmp(emp);
		}

		return ResponseEntity.ok (response);

	}
	@GetMapping("findAllemployee")
	public ResponseEntity<Object> getAllEmployee() {
		//StatusDto responseDto = new StatusDto();
		List<Employee>list=new ArrayList<Employee>();

//		LOGGER.info("Received getAllProject request");
		try {
			list = employeeService.findAllEmployee();
			return ResponseEntity.ok(list);
		} catch (Exception e) {
//			LOGGER.error("Error occurred during getAllProject: {}", e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An error occurred during getAllProject");
		}
	}
	
	
	@GetMapping("deleteemployee/{empId}")
	public ResponseEntity<Object> deactivateProject(
			@RequestBody EmployeeDto dto) {
		StatusDto responseDto = new StatusDto();

		try {
			responseDto = employeeService.removeEmployeeByEmpId(dto);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An error occurred during deactivateProject");
		}
		return ResponseEntity.ok(responseDto);
	}


}
