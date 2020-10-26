package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.ProjectCategoryDto;
import com.igor1c.portfolio.dto.ProjectPropertyDto;
import com.igor1c.portfolio.entities.ProjectCategoryEntity;
import com.igor1c.portfolio.entities.ProjectPropertyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectCategoryMapper {
    ProjectCategoryMapper INSTANCE = Mappers.getMapper(ProjectCategoryMapper.class);

    ProjectCategoryDto fromEntity(ProjectCategoryEntity entity);
}
