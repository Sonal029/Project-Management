package com.project.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;
	
	@NotBlank(message = "Mandatory field")
	private String name;
	
	@NotBlank(message = "Mandatory field")
	@PastOrPresent
	private LocalDate hireDate;
	
	 @ManyToMany(mappedBy = "employees")
	    private Set<Project> projects = new HashSet<>();

	    @ManyToMany
	    @JoinTable(name = "Employee_Role",
	            joinColumns = @JoinColumn(name = "employee_id"),
	            inverseJoinColumns = @JoinColumn(name = "role_id"))
	    private Set<Role> roles = new HashSet<>();
}
