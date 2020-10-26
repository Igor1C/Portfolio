package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.LanguageDto;
import com.igor1c.portfolio.dto.PurposeDto;
import com.igor1c.portfolio.entities.LanguageEntity;
import com.igor1c.portfolio.entities.PurposeEntity;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-25T01:28:03+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class PurposeMapperImpl implements PurposeMapper {

    @Override
    public PurposeDto fromEntity(PurposeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        PurposeDto purposeDto = new PurposeDto();

        purposeDto.setId( entity.getId() );
        purposeDto.setLanguage( languageEntityToLanguageDto( entity.getLanguage() ) );
        purposeDto.setDescription( entity.getDescription() );
        purposeDto.setListOrder( entity.getListOrder() );

        return purposeDto;
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
