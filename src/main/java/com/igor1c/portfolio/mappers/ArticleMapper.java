package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.ArticleDto;
import com.igor1c.portfolio.entities.ArticleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleMapper {
    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    ArticleDto fromEntity(ArticleEntity articleEntity);
}
