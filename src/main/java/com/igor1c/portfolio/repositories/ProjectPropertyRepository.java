package com.igor1c.portfolio.repositories;

import com.igor1c.portfolio.entities.AdditionalPropertyValueEntity;
import com.igor1c.portfolio.entities.ProjectEntity;
import com.igor1c.portfolio.entities.ProjectPropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("projectPropertyRepository")
public interface ProjectPropertyRepository extends JpaRepository<ProjectPropertyEntity, Long> {

    List<ProjectPropertyEntity> findByProject(ProjectEntity project);

    List<ProjectPropertyEntity> findByPropertyValue(AdditionalPropertyValueEntity propertyValue);
}
