package com.practiceProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practiceProject.model.Projects;

@Repository
public interface ProjectRepository extends JpaRepository<Projects, Integer> {

}
