package com.igor1c.portfolio.repositories;

import com.igor1c.portfolio.entities.DescriptionEntity;
import com.igor1c.portfolio.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("descriptionRepository")
public interface DescriptionRepository extends JpaRepository<DescriptionEntity, Long> {

    List<DescriptionEntity> findByProject(ProjectEntity project);
}
