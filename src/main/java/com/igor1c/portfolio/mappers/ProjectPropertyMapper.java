package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.ProjectPropertyDto;
import com.igor1c.portfolio.entities.ProjectPropertyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectPropertyMapper {
    ProjectPropertyMapper INSTANCE = Mappers.getMapper(ProjectPropertyMapper.class);

    ProjectPropertyDto fromEntity(ProjectPropertyEntity entity);
}
