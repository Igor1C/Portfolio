package com.igor1c.portfolio.repositories;

import com.igor1c.portfolio.entities.AdditionalPropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("additionalPropertyRepository")
public interface AdditionalPropertyRepository extends JpaRepository<AdditionalPropertyEntity, Long> {

    List<AdditionalPropertyEntity> findByName(String name);
}
