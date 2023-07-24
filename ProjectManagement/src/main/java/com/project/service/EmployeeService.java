package com.project.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.ProjectException;
import com.project.model.Department;
import com.project.model.Employee;
import com.project.model.Project;
import com.project.model.Role;
import com.project.repository.DepartmentRepository;
import com.project.repository.EmployeeRepository;
import com.project.repository.ProjectRepository;
import com.project.repository.RoleRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
    private DepartmentRepository deptRepo;
	
	public String addEmployee(Employee employee)
	{
		empRepo.save(employee);
		return("Department added sucessfully");
	}
	
	public Employee getListOfProject(Integer employeeId) throws ProjectException
	{
		Optional<Employee> optEmp =  empRepo.findById(employeeId);
		if(optEmp.isPresent())
		{
			Employee emp = optEmp.get();
			emp.getProjects().size();
            emp.getRoles().size();
            return emp;
        } else {
            // Handle the case where the employeeId does not exist.
            throw new ProjectException("Employee not found with ID: " + employeeId);
        }
	}
	
	public Employee assignProject(Integer employeeId , Integer projectId, Integer roleId) throws ProjectException
	{
		Optional<Employee> optEmp =  empRepo.findById(employeeId);
		if(optEmp.isPresent())
		{
			Employee emp = optEmp.get();
			
			Optional<Project> optionalProject = projectRepo.findById(projectId);
			
			 if (optionalProject.isPresent()) {
	                Project project = optionalProject.get();
	                emp.getProjects().add(project);
	                project.getEmployees().add(emp);
	            } else {
	                throw new ProjectException("Project not found with ID: " + projectId);
	            }

	            Optional<Role> optionalRole = roleRepo.findById(roleId);
	            if (optionalRole.isPresent()) {
	                Role role = optionalRole.get();
	                emp.getRoles().add(role);
	                role.getEmployees().add(emp);
	            } else {
	                throw new ProjectException("Role not found with ID: " + roleId);
	            }

	            return empRepo.save(emp);
		}
		else
		{
            throw new ProjectException("Employee not found with ID: " + employeeId);
		}
	}

	public Project getListofEmployeeBasedOnProjectId(Integer projectId) throws ProjectException
	{
		Optional<Project> optionalProject = projectRepo.findById(projectId);
		
		 if (optionalProject.isPresent()) {
               Project project = optionalProject.get();
               
               project.getEmployees().size();
               project.getDepartment().getDepartmentName(); // Load department name (or other properties) directly

               return project;
               
               }
		 else
		 {
	            throw new ProjectException("Project not found with ID: " + projectId);

		 }
	}
	
	public Project assignProjectToDifferentDepartment(Integer projectId, Integer departmentId) throws ProjectException {
        Optional<Project> optionalProject = projectRepo.findById(projectId);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();

            Optional<Department> optionalDepartment = deptRepo.findById(departmentId);
            if (optionalDepartment.isPresent()) {
                Department department = optionalDepartment.get();
                project.setDepartment(department);
                return projectRepo.save(project);
            } else {
                throw new ProjectException("Department not found with ID: " + departmentId);
            }
        } else {
            throw new ProjectException("Project not found with ID: " + projectId);
        }
    }

   
}

