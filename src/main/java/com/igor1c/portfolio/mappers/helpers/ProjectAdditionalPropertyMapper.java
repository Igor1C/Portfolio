package com.igor1c.portfolio.mappers.helpers;

import com.igor1c.portfolio.dto.helpers.ProjectAdditionalPropertyDto;
import com.igor1c.portfolio.entities.helpers.ProjectAdditionalProperty;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectAdditionalPropertyMapper {
    ProjectAdditionalPropertyMapper INSTANCE = Mappers.getMapper(ProjectAdditionalPropertyMapper.class);

    ProjectAdditionalPropertyDto fromEntity(ProjectAdditionalProperty entity);
}
