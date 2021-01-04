package com.project.pm.dao;

import java.util.List;

import com.project.pm.dto.ChartData;
import com.project.pm.entities.Project;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    
    @Override
    public List<Project> findAll();

    @Query(nativeQuery = true, value="SELECT stage as label, count(*) as value from project group by stage;")
    public List<ChartData> getProjectStatus();
}
