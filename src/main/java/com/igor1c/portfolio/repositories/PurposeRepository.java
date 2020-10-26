package com.igor1c.portfolio.repositories;

import com.igor1c.portfolio.entities.ProjectEntity;
import com.igor1c.portfolio.entities.PurposeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("purposeRepository")
public interface PurposeRepository extends JpaRepository<PurposeEntity, Long> {

    List<PurposeEntity> findByProject(ProjectEntity project);
}
