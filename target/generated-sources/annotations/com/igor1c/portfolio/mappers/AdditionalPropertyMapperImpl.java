package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.AdditionalPropertyDto;
import com.igor1c.portfolio.entities.AdditionalPropertyEntity;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-25T01:28:03+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class AdditionalPropertyMapperImpl implements AdditionalPropertyMapper {

    @Override
    public AdditionalPropertyDto fromEntity(AdditionalPropertyEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AdditionalPropertyDto additionalPropertyDto = new AdditionalPropertyDto();

        additionalPropertyDto.setId( entity.getId() );
        additionalPropertyDto.setName( entity.getName() );

        return additionalPropertyDto;
    }
}
