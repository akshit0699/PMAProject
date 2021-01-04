package com.project.pm.dao;

import java.util.List;

import com.project.pm.dto.EmployeeProject;
import com.project.pm.entities.Employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Override
    public List<Employee> findAll();

    @Query(nativeQuery = true, value="SELECT e.first_name AS firstName, e.last_name AS lastName , COUNT( pe.employee_id) AS projectCount "+
    "FROM employee e LEFT JOIN project_employee pe ON pe.employee_id = e.employee_id "+
    "GROUP BY e.first_name, e.last_name ORDER BY 3 DESC")
    public List<EmployeeProject> employeeProjects();
}
