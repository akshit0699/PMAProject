package com.project.pm.entities;

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


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;
    private String firstName;
    private String lastName;
    private String email;

    @ManyToMany(cascade = {CascadeType.DETACH,
        CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
        fetch = FetchType.LAZY )
    @JoinTable(name="project_employee",
    joinColumns = @JoinColumn(name="employee_id"),
    inverseJoinColumns = @JoinColumn(name="project_id"))
    private List<Project> projects;


    public Employee() {
    }

    public Employee(String firstName, String lastName, String email) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public List<Project> getProjects() {
        return this.projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee employeeId(long employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public Employee firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Employee lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Employee email(String email) {
        this.email = email;
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " employeeId='" + getEmployeeId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }



}
