package com.project.pm.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

// Turning a class into an entity
// Create project from form --> Hit submit --> project entity is going
// to be created and that is going to be inserted into the DB
// THIS CLASS STRUCTURE IS ESSENTIALLY GOING TO MAP
// TO A TABLE STRUCTURE IN THE DATABASE
// Each row will have a projectId, name, stage and info

// So this is a kind of mapping from the java world --> db world
// Thanks to java persistance library, we can do that (JPA used)
// Hibernate+JPA+Persistance TO RESUCE!

// Mark the class as an entity! Hence it will be identified as a table
// by spring 

@Entity
public class Project {
    // Mapping java objects to database tables
    // using hibernate terminology

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectId; // db must generate this, uniquely
    private String name;
    private String stage; // status of the project
    private String info;

    @ManyToMany(cascade = {CascadeType.DETACH,
        CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
        fetch = FetchType.LAZY )
    @JoinTable(name="project_employee",
    joinColumns = @JoinColumn(name="project_id"),
    inverseJoinColumns = @JoinColumn(name="employee_id"))
    private List<Employee> employees;

    public Project() {
    }

    public Project(String name, String stage, String info) {
        
        this.name = name;
        this.stage = stage;
        this.info = info;
    }

    public List<Employee> getEmployees(){
        return employees;
    }

    public void setEmployees(List<Employee> employees){
        this.employees = employees;
    }

    public long getProjectId() {
        return this.projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStage() {
        return this.stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Project projectId(long projectId) {
        this.projectId = projectId;
        return this;
    }

    public Project name(String name) {
        this.name = name;
        return this;
    }

    public Project stage(String stage) {
        this.stage = stage;
        return this;
    }

    public Project info(String info) {
        this.info = info;
        return this;
    }

    // Data addition convinience method
    public void addEmployee(Employee emp){
        if(employees == null){
            employees = new ArrayList<>();
        }

        employees.add(emp);
    }


    @Override
    public String toString() {
        return "{" +
            " projectId='" + getProjectId() + "'" +
            ", name='" + getName() + "'" +
            ", stage='" + getStage() + "'" +
            ", info='" + getInfo() + "'" +
            "}";
    }


}
