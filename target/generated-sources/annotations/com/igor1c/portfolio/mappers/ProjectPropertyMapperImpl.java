package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.AdditionalPropertyDto;
import com.igor1c.portfolio.dto.AdditionalPropertyValueDto;
import com.igor1c.portfolio.dto.ProjectPropertyDto;
import com.igor1c.portfolio.entities.AdditionalPropertyEntity;
import com.igor1c.portfolio.entities.AdditionalPropertyValueEntity;
import com.igor1c.portfolio.entities.ProjectPropertyEntity;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-25T01:28:03+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class ProjectPropertyMapperImpl implements ProjectPropertyMapper {

    @Override
    public ProjectPropertyDto fromEntity(ProjectPropertyEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ProjectPropertyDto projectPropertyDto = new ProjectPropertyDto();

        projectPropertyDto.setId( entity.getId() );
        projectPropertyDto.setPropertyValue( additionalPropertyValueEntityToAdditionalPropertyValueDto( entity.getPropertyValue() ) );

        return projectPropertyDto;
    }

    protected AdditionalPropertyDto additionalPropertyEntityToAdditionalPropertyDto(AdditionalPropertyEntity additionalPropertyEntity) {
        if ( additionalPropertyEntity == null ) {
            return null;
        }

        AdditionalPropertyDto additionalPropertyDto = new AdditionalPropertyDto();

        additionalPropertyDto.setId( additionalPropertyEntity.getId() );
        additionalPropertyDto.setName( additionalPropertyEntity.getName() );

        return additionalPropertyDto;
    }

    protected AdditionalPropertyValueDto additionalPropertyValueEntityToAdditionalPropertyValueDto(AdditionalPropertyValueEntity additionalPropertyValueEntity) {
        if ( additionalPropertyValueEntity == null ) {
            return null;
        }

        AdditionalPropertyValueDto additionalPropertyValueDto = new AdditionalPropertyValueDto();

        additionalPropertyValueDto.setId( additionalPropertyValueEntity.getId() );
        additionalPropertyValueDto.setAdditionalProperty( additionalPropertyEntityToAdditionalPropertyDto( additionalPropertyValueEntity.getAdditionalProperty() ) );
        additionalPropertyValueDto.setName( additionalPropertyValueEntity.getName() );

        return additionalPropertyValueDto;
    }
}
