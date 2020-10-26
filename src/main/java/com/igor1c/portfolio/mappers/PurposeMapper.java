package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.PurposeDto;
import com.igor1c.portfolio.entities.PurposeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PurposeMapper {
    PurposeMapper INSTANCE = Mappers.getMapper(PurposeMapper.class);

    PurposeDto fromEntity(PurposeEntity entity);
}
