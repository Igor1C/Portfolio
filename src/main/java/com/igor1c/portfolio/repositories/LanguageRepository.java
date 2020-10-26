package com.igor1c.portfolio.repositories;

import com.igor1c.portfolio.entities.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("languageRepository")
public interface LanguageRepository extends JpaRepository<LanguageEntity, Long> {

    LanguageEntity findByName(String name);
}
