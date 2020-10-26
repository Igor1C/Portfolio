package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.DescriptionDto;
import com.igor1c.portfolio.entities.DescriptionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DescriptionMapper {
    DescriptionMapper INSTANCE = Mappers.getMapper(DescriptionMapper.class);

    DescriptionDto fromEntity(DescriptionEntity entity);
}
