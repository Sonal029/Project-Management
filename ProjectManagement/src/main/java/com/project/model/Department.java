package com.project.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer departmentId;
	
	@NotBlank(message = "Mandatory Field")
	private String departmentName;
	
	@NotBlank(message = "Mandatory Field")
	private String location;
	
	@OneToMany(mappedBy = "department")
    private Set<Project> projects = new HashSet<>();
}
