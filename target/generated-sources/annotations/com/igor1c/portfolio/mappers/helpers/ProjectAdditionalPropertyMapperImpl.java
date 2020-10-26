package com.igor1c.portfolio.mappers.helpers;

import com.igor1c.portfolio.dto.AdditionalPropertyDto;
import com.igor1c.portfolio.dto.AdditionalPropertyValueDto;
import com.igor1c.portfolio.dto.helpers.ProjectAdditionalPropertyDto;
import com.igor1c.portfolio.entities.AdditionalPropertyEntity;
import com.igor1c.portfolio.entities.AdditionalPropertyValueEntity;
import com.igor1c.portfolio.entities.helpers.ProjectAdditionalProperty;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-25T01:28:02+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class ProjectAdditionalPropertyMapperImpl implements ProjectAdditionalPropertyMapper {

    @Override
    public ProjectAdditionalPropertyDto fromEntity(ProjectAdditionalProperty entity) {
        if ( entity == null ) {
            return null;
        }

        ProjectAdditionalPropertyDto projectAdditionalPropertyDto = new ProjectAdditionalPropertyDto();

        projectAdditionalPropertyDto.setAdditionalPropertyEntity( additionalPropertyEntityToAdditionalPropertyDto( entity.getAdditionalPropertyEntity() ) );
        projectAdditionalPropertyDto.setAdditionalPropertyValueList( additionalPropertyValueEntityListToAdditionalPropertyValueDtoList( entity.getAdditionalPropertyValueList() ) );

        return projectAdditionalPropertyDto;
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

    protected List<AdditionalPropertyValueDto> additionalPropertyValueEntityListToAdditionalPropertyValueDtoList(List<AdditionalPropertyValueEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<AdditionalPropertyValueDto> list1 = new ArrayList<AdditionalPropertyValueDto>( list.size() );
        for ( AdditionalPropertyValueEntity additionalPropertyValueEntity : list ) {
            list1.add( additionalPropertyValueEntityToAdditionalPropertyValueDto( additionalPropertyValueEntity ) );
        }

        return list1;
    }
}
