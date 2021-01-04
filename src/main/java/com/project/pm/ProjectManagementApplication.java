package com.project.pm;

import com.project.pm.dao.EmployeeRepository;
import com.project.pm.dao.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProjectManagementApplication {

	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	ProjectRepository projRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}


}
