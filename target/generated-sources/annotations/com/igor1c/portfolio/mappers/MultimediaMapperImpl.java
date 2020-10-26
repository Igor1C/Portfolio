package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.LanguageDto;
import com.igor1c.portfolio.dto.MultimediaDto;
import com.igor1c.portfolio.entities.LanguageEntity;
import com.igor1c.portfolio.entities.MultimediaEntity;
import java.util.Arrays;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-25T01:28:03+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class MultimediaMapperImpl implements MultimediaMapper {

    @Override
    public MultimediaDto fromEntity(MultimediaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        MultimediaDto multimediaDto = new MultimediaDto();

        multimediaDto.setId( entity.getId() );
        multimediaDto.setLanguage( languageEntityToLanguageDto( entity.getLanguage() ) );
        byte[] data = entity.getData();
        if ( data != null ) {
            multimediaDto.setData( Arrays.copyOf( data, data.length ) );
        }
        multimediaDto.setLink( entity.getLink() );

        return multimediaDto;
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
