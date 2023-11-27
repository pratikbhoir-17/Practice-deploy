package com.practiceProject.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;


public class EmployeeDto {
	public int id;
	@Size(min = 5, max = 20, message = "fullName must be between 5 and 20 character")
	@Pattern(regexp = "[^0-9]*", message = "fullName must not contain numbers")
	@NotBlank(message = "fullName is mandatory field")
	private String fullName;
	@Size(min = 4, max = 5, message = "empId must be between 4 and 5 numbers")
	@Pattern(regexp = "[^A-Z,a-z]*", message = "empId must not contain characeters")
	@NotBlank(message = "empId is mandatory field")
	private String empId;
	@Pattern(regexp = "\\d{10}", message = "phoneNo number must have exactly 10 digits")
	private String phoneNo;
	@Size(min = 4, max = 30, message = "designation must be between 6 and 30 numbers")
	@Pattern(regexp = "[^0-9]*", message = "designation must not contain characeters")
	@NotBlank(message = "designation is mandatory field")
	private String designation;
	private String address;
	private String deletedFlag;
	private int role;
	private String joiningDate;
	@Size(min = 4, max = 30, message = "mailId must be between 4 and 30 numbers")
	@Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,30})$")
	@NotBlank(message = "mailId is mandatory field")
	private String mailId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDeletedFlag() {
		return deletedFlag;
	}
	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", fullName=" + fullName + ", empId=" + empId + ", phoneNo=" + phoneNo
				+ ", designation=" + designation + ", address=" + address + ", deletedFlag=" + deletedFlag + ", role="
				+ role + ", joiningDate=" + joiningDate + ", mailId=" + mailId + "]";
	}

}
