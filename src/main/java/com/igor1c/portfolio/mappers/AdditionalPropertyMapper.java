package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.AdditionalPropertyDto;
import com.igor1c.portfolio.entities.AdditionalPropertyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdditionalPropertyMapper {
    AdditionalPropertyMapper INSTANCE = Mappers.getMapper(AdditionalPropertyMapper.class);

    AdditionalPropertyDto fromEntity(AdditionalPropertyEntity entity);
}
