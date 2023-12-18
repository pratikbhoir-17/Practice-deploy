package com.practiceProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practiceProject.model.Projects;


@Repository
public interface ProjectRepository extends JpaRepository<Projects, Integer> {
	public List<Projects> findByprojectId(String projectId); 
	public List<Projects> findBystatus(String status);
	//public Employee findBymailId(String mailId);
}
