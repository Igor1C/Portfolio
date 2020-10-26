package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.CategoryDto;
import com.igor1c.portfolio.entities.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto fromEntity(CategoryEntity entity);
}
