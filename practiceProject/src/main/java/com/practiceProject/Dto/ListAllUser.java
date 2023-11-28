package com.practiceProject.Dto;

import java.util.List;



public class ListAllUser {
	private List<EmployeeDto>listAllUsers;
	private String empId;
	public List<EmployeeDto> getListAllUsers() {
		return listAllUsers;
	}
	public void setListAllUsers(List<EmployeeDto> listAllUsers) {
		this.listAllUsers = listAllUsers;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	@Override
	public String toString() {
		return "ListAllUser [listAllUsers=" + listAllUsers + ", empId=" + empId + "]";
	}


	
}
