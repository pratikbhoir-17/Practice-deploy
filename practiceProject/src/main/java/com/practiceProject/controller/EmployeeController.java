package com.practiceProject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practiceProject.Dto.EmployeeDto;
import com.practiceProject.Dto.StatusDto;
import com.practiceProject.model.Employee;
import com.practiceProject.service.EmployeeService;
import com.practiceProject.util.Constants;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidatorFactory;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class EmployeeController {
	@Autowired
	public EmployeeService employeeService;

	@PostMapping("/")
	public String Testing() {
		return "Welcome";

	}

	@PostMapping("/addEmployee")
	public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto emp) {
		log.info("Inside EmployeeController ==> addEmployee() " + emp);
		 List<StatusDto> reslist = new ArrayList<StatusDto>();
		 StatusDto response = new StatusDto();
		ValidatorFactory factory = jakarta.validation.Validation.buildDefaultValidatorFactory();
		jakarta.validation.Validator validator = factory.getValidator();
		Set<ConstraintViolation<EmployeeDto>> violations = validator.validate(emp);
		for (ConstraintViolation<EmployeeDto> violation : violations) {
			response.setCode(Constants.ADSS100);
			response.setMessage(violation.getMessage());
			reslist.add(response);
			return ResponseEntity.ok(reslist);
		}
		if (reslist.isEmpty()) {
		response=employeeService.addEmp(emp);
		}

		return ResponseEntity.ok (response);

	}

}