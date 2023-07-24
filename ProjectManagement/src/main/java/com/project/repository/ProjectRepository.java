package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
