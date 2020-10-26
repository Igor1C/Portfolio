package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.MultimediaDto;
import com.igor1c.portfolio.entities.MultimediaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MultimediaMapper {
    MultimediaMapper INSTANCE = Mappers.getMapper(MultimediaMapper.class);

    MultimediaDto fromEntity(MultimediaEntity entity);
}
