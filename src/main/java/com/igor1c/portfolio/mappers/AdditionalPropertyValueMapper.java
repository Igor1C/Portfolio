package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.AdditionalPropertyValueDto;
import com.igor1c.portfolio.entities.AdditionalPropertyValueEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdditionalPropertyValueMapper {
    AdditionalPropertyValueMapper INSTANCE = Mappers.getMapper(AdditionalPropertyValueMapper.class);

    AdditionalPropertyValueDto fromEntity(AdditionalPropertyValueEntity entity);
}
