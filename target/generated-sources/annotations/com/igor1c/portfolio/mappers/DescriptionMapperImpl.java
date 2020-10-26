package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.DescriptionDto;
import com.igor1c.portfolio.dto.LanguageDto;
import com.igor1c.portfolio.entities.DescriptionEntity;
import com.igor1c.portfolio.entities.LanguageEntity;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-25T01:28:03+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class DescriptionMapperImpl implements DescriptionMapper {

    @Override
    public DescriptionDto fromEntity(DescriptionEntity entity) {
        if ( entity == null ) {
            return null;
        }

        DescriptionDto descriptionDto = new DescriptionDto();

        descriptionDto.setId( entity.getId() );
        descriptionDto.setLanguage( languageEntityToLanguageDto( entity.getLanguage() ) );
        descriptionDto.setShortDescription( entity.getShortDescription() );
        descriptionDto.setHtmlShortDescription( entity.getHtmlShortDescription() );
        descriptionDto.setDescription( entity.getDescription() );
        descriptionDto.setHtmlDescription( entity.getHtmlDescription() );

        return descriptionDto;
    }

    protected LanguageDto languageEntityToLanguageDto(LanguageEntity languageEntity) {
        if ( languageEntity == null ) {
            return null;
        }

        LanguageDto languageDto = new LanguageDto();

        languageDto.setId( languageEntity.getId() );
        languageDto.setName( languageEntity.getName() );

        return languageDto;
    }
}
