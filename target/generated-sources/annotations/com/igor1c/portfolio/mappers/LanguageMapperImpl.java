package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.LanguageDto;
import com.igor1c.portfolio.entities.LanguageEntity;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-25T01:28:03+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class LanguageMapperImpl implements LanguageMapper {

    @Override
    public LanguageDto fromEntity(LanguageEntity entity) {
        if ( entity == null ) {
            return null;
        }

        LanguageDto languageDto = new LanguageDto();

        languageDto.setId( entity.getId() );
        languageDto.setName( entity.getName() );

        return languageDto;
    }
}
