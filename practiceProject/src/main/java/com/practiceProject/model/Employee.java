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
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
public int id;
	private String fullName;
	private String empId;
	private String phoneNo;
	private String designation;
	private String address;
	private String deletedFlag;
	private int role;
	private String joiningDate;
	private String mailId;

}
