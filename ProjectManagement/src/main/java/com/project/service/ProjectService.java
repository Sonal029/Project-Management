package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Project;
import com.project.repository.ProjectRepository;

@Service
public class ProjectService {

	
	@Autowired
	private ProjectRepository projectRepo;
	
	public String addEmployee(Project project)
	{
		projectRepo.save(project);
		return("Project added sucessfully");
	}
}
