package com.project.pm.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.pm.dao.EmployeeRepository;
import com.project.pm.dao.ProjectRepository;
import com.project.pm.dto.ChartData;
import com.project.pm.dto.EmployeeProject;
import com.project.pm.entities.Employee;
import com.project.pm.entities.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
        Map<String, Object> mymapping = new HashMap<>();

        List <Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects);

        List<ChartData> projectData = proRepo.getProjectStatus();
        // Adding a few lines here
        // The projectData is a List, hence can't be used as such in JS
        // SO we use ObjectMapper to turn it into a JSON string,
        // that looks like:
        // [["NOTSTARTED",1], ["INPROGRESS",3], ["COMPLETED", 0]]
        ObjectMapper objectMapper =  new ObjectMapper();
        String jsonData = objectMapper.writeValueAsString(projectData);
        // Send it to the chart
        model.addAttribute("projectStatusCnt", jsonData);
        

        List<EmployeeProject> employeesCnt = empRepo.employeeProjects();
        model.addAttribute("empProjCnt", employeesCnt);
        return "main/home";
    }
}
