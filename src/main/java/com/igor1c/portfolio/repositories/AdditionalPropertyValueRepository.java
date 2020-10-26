package com.igor1c.portfolio.repositories;

import com.igor1c.portfolio.entities.AdditionalPropertyValueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("additionalPropertyValueRepository")
public interface AdditionalPropertyValueRepository extends JpaRepository<AdditionalPropertyValueEntity, Long> {

    List<AdditionalPropertyValueEntity> findByAdditionalProperty(Long id);
}
