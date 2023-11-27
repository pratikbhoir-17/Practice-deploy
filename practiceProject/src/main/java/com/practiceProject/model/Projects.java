package com.practiceProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class Projects {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
public int id;
	private String name;
	private String projectId;
	private String organization;
	private String sector;
	private String status;
	private String empId;

}
