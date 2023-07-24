package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Role;
import com.project.repository.RoleRepository;

@Service
public class RoleService {

	
	@Autowired
	private RoleRepository roleRepo;
	
	public String addEmployee(Role role)
	{
		roleRepo.save(role);
		return("Role added sucessfully");
	}
}
