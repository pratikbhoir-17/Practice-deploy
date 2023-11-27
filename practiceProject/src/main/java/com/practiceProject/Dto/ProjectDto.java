package com.practiceProject.Dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProjectDto {
	public int id;
	private String name;
	private String projectId;
	private String organization;
	private String sector;
	private String status;
	private String empId;

}
