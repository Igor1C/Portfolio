package com.igor1c.portfolio.repositories;

import com.igor1c.portfolio.entities.ArticleContentEntity;
import com.igor1c.portfolio.entities.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("articleContentRepository")
public interface ArticleContentRepository extends JpaRepository<ArticleContentEntity, Long> {

    List<ArticleContentEntity> findByArticle(ArticleEntity article);
}
