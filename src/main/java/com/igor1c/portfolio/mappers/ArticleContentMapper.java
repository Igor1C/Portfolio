package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.ArticleContentDto;
import com.igor1c.portfolio.entities.ArticleContentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleContentMapper {
    ArticleContentMapper INSTANCE = Mappers.getMapper(ArticleContentMapper.class);

    ArticleContentDto fromEntity(ArticleContentEntity articleContentEntity);
}
