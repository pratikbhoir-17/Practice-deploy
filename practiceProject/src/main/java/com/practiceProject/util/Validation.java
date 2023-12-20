package com.practiceProject.util;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Validation {
	@Size(min = 5, max = 20, message = "fullName must be between 5 and 20 character")
	@Pattern(regexp = "[^0-9]*", message = "fullName must not contain numbers")
	@NotBlank(message = "fullName is mandatory field")
	private String fullName;

	@Pattern(regexp = "\\d{10}", message = "phoneNo number must have exactly 10 digits")
	private String phoneNo;
	@Size(min = 4, max = 5, message = "empId must be between 4 and 5 numbers")
	@Pattern(regexp = "[^A-Z,a-z]*", message = "empId must not contain characeters")
	@NotBlank(message = "empId is mandatory field")
	String empId;
	@Size(min = 4, max = 30, message = "designation must be between 6 and 30 numbers")
	@Pattern(regexp = "[^0-9]*", message = "designation must not contain characeters")
	@NotBlank(message = "designation is mandatory field")
	String designation;
	@Size(min = 4, max = 30, message = "mailId must be between 4 and 30 numbers")
	@Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,30})$")
	@NotBlank(message = "mailId is mandatory field")
	String mailId;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	@Override
	public String toString() {
		return "Validation [fullName=" + fullName + ", phoneNo=" + phoneNo + ", empId=" + empId + ", designation="
				+ designation + ", mailId=" + mailId + "]";
	}

}
