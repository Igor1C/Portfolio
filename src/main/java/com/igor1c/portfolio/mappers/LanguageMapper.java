package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.LanguageDto;
import com.igor1c.portfolio.entities.LanguageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LanguageMapper {
    LanguageMapper INSTANCE = Mappers.getMapper(LanguageMapper.class);

    LanguageDto fromEntity(LanguageEntity entity);
}
