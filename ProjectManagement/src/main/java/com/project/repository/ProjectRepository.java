package com.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{

	Optional<Project> findById(Integer projectId);

}
