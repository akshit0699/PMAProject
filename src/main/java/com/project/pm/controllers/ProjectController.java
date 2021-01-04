package com.project.pm.controllers;

import java.util.List;

import com.project.pm.dao.EmployeeRepository;
import com.project.pm.dao.ProjectRepository;
import com.project.pm.entities.Employee;
import com.project.pm.entities.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;


    @GetMapping
    public String displayProjects(Model model){
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects);
        return "projects/list-projects";
    }

    @RequestMapping("/new")
    public String displayProjectForm(Model model){

        model.addAttribute("project", new Project());

        List<Employee> employees = empRepo.findAll();
        model.addAttribute("allEmployees", employees);
        return "projects/new-projects";
    }

    @PostMapping(value="/save")
    public String createProject(Project project,
     Model model) {
        // This will handle saving data into the DB, via CRUD operations
        proRepo.save(project);
        // use a redirect when trying to save to a database
        // To prevent duplicate submissions (example: if the user hits submit)
        // again and again it might cause errors
        return "redirect:/projects";
    }
    

}
