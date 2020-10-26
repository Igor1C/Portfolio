package com.igor1c.portfolio.repositories;

import com.igor1c.portfolio.entities.CategoryEntity;
import com.igor1c.portfolio.entities.ProjectCategoryEntity;
import com.igor1c.portfolio.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("projectCategoryRepository")
public interface ProjectCategoryRepository extends JpaRepository<ProjectCategoryEntity, Long> {

    List<ProjectCategoryEntity> findByProject(ProjectEntity project);

    List<ProjectCategoryEntity> findByCategory(CategoryEntity category);
}
