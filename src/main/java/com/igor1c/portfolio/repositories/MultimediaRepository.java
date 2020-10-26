package com.igor1c.portfolio.repositories;

import com.igor1c.portfolio.entities.MultimediaEntity;
import com.igor1c.portfolio.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("multimediaRepository")
public interface MultimediaRepository extends JpaRepository<MultimediaEntity, Long> {

    List<MultimediaEntity> findByProject(ProjectEntity project);
}
