# Project Management System

![image](https://i.ibb.co/vYPhf4h/Screenshot-82.png)

The Project Management System is an application designed to efficiently manage Employees, Projects, Departments, and Roles, along with their relationships. This system allows users to assign Employees to multiple Projects and Roles, assign Projects to Departments, and perform various queries to find specific information about Employees, Projects, and their associations.

## Table of Contents

### Features
### Installation
### Usage
### Entity Classes
### Methods
### Exception Handling
### Acknowledgments

## Features
Manage Employees, Projects, Departments, and Roles with their respective attributes.

Establish bidirectional relationships between Employees and Projects, Employees and Roles, and Departments and Projects.

Assign Projects and Roles to Employees based on their IDs.

Assign Projects to different Departments based on their IDs.


Proper exception handling for invalid or missing data.

## Installation
Clone the repository to your local machine:

git clone https://github.com/Sonal029/Project-Management

Ensure you have Java and Maven installed on your system.

## Usage
The application will start, and you can access it through the provided API endpoints.

Use tools like Postman or cURL to interact with the API and perform CRUD operations on Employees, Projects, Departments, and Roles.

Use the provided API methods to assign Projects and Roles to Employees, assign Projects to Departments, and perform queries to find specific information about Employees, Projects, and their associations.
Entity Classes

Employee: Represents an employee with a unique employeeId, name, and hireDate.

Project: Represents a project with a unique projectId, projectName, and startDate.

Department: Represents a department with a unique departmentId, departmentName, and location.

Role: Represents a role with a unique roleId and roleName.

## Methods
The Project Management System provides the following methods through its API:

POST /employees: Add a new Employee to the system.

POST /projects: Add a new Project to the system.

POST /departments: Add a new Department to the system.

POST /roles: Add a new Role to the system.

PUT /employees/{employeeId}/assignProject/{projectId}: Assign an existing Project to an existing Employee.

PUT /employees/{employeeId}/assignRole/{roleId}: Assign an existing Role to an existing Employee.

PUT /projects/{projectId}/assignDepartment/{departmentId}: Assign an existing Project to a different existing Department.

GET /employees/{employeeId}: Get an Employee along with their list of Projects and Roles.

GET /projects/{projectId}: Get a Project along with its list of Employees and associated Department.

## Exception Handling
The Project Management System has robust exception handling to handle various scenarios, such as invalid data, missing resources, and other potential errors. Custom exception classes have been created for different error cases to provide meaningful error messages to users.

## Acknowledgments
We would like to express our gratitude to the entire development team for their hard work in bringing this Project Management System to life. Special thanks to the open-source community and contributors for their valuable libraries and tools that made this project possible.

Thank you for using the Project Management System! If you have any questions or feedback, please feel free to reach out to us. Happy managing!

## Shakamabhari ("https://github.com/Sonal029")
