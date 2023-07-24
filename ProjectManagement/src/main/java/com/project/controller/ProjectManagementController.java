package com.project.controller;
		
	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.exception.ProjectException;
import com.project.model.Department;
import com.project.model.Employee;
import com.project.model.Project;
import com.project.model.Role;
import com.project.service.ProjectManagementService;

	@RestController
	@RequestMapping("/api")
	public class ProjectManagementController {

	    private final ProjectManagementService projectManagementService;

	    @Autowired
	    public ProjectManagementController(ProjectManagementService projectManagementService) {
	        this.projectManagementService = projectManagementService;
	    }

	    // Endpoint to add a new Employee
	    @PostMapping("/employees")
	    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
	        Employee newEmployee = projectManagementService.addEmployee(employee);
	        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	    }

	    // Endpoint to add a new Project
	    @PostMapping("/projects")
	    public ResponseEntity<Project> addProject(@RequestBody Project project) {
	        Project newProject = projectManagementService.addProject(project);
	        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
	    }

	    // Endpoint to add a new Department
	    @PostMapping("/departments")
	    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
	        Department newDepartment = projectManagementService.addDepartment(department);
	        return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
	    }

	    // Endpoint to add a new Role
	    @PostMapping("/roles")
	    public ResponseEntity<Role> addRole(@RequestBody Role role) {
	        Role newRole = projectManagementService.addRole(role);
	        return new ResponseEntity<>(newRole, HttpStatus.CREATED);
	    }

	    // Endpoint to assign a Project to an Employee
	    @PutMapping("/employees/{employeeId}/assignProject/{projectId}")
	    public ResponseEntity<Employee> assignProjectToEmployee(
	            @PathVariable Integer employeeId, @PathVariable Integer projectId) throws ProjectException {
	        Employee employee = projectManagementService.assignProjectToEmployee(employeeId, projectId);
	        return new ResponseEntity<>(employee, HttpStatus.OK);
	    }

	    // Endpoint to assign a Project to a different Department
	    @PutMapping("/projects/{projectId}/assignDepartment/{departmentId}")
	    public ResponseEntity<Project> assignProjectToDepartment(
	            @PathVariable Integer projectId, @PathVariable Integer departmentId) throws ProjectException {
	        Project project = projectManagementService.assignProjectToDifferentDepartment(projectId, departmentId);
	        return new ResponseEntity<>(project, HttpStatus.OK);
	    }

	    // Endpoint to get an Employee with Projects and Roles by employeeId
	    @GetMapping("/employees/{employeeId}")
	    public ResponseEntity<Employee> getEmployeeWithProjectsAndRoles(@PathVariable Integer employeeId) throws ProjectException {
	        Employee employee = projectManagementService.getEmployeeWithProjectsAndRoles(employeeId);
	        return new ResponseEntity<>(employee, HttpStatus.OK);
	    }

	    // Endpoint to get a Project with Employees and the associated Department by projectId
	    @GetMapping("/projects/{projectId}")
	    public ResponseEntity<Project> getProjectWithEmployeesAndDepartment(@PathVariable Integer projectId) throws ProjectException {
	        Project project = projectManagementService.getProjectWithEmployeesAndDepartment(projectId);
	        return new ResponseEntity<>(project, HttpStatus.OK);
	    }

	}

