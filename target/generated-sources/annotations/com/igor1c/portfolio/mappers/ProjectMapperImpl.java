package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.AdditionalPropertyDto;
import com.igor1c.portfolio.dto.AdditionalPropertyValueDto;
import com.igor1c.portfolio.dto.CategoryDto;
import com.igor1c.portfolio.dto.DescriptionDto;
import com.igor1c.portfolio.dto.LanguageDto;
import com.igor1c.portfolio.dto.MultimediaDto;
import com.igor1c.portfolio.dto.ProjectCategoryDto;
import com.igor1c.portfolio.dto.ProjectDto;
import com.igor1c.portfolio.dto.ProjectPropertyDto;
import com.igor1c.portfolio.dto.PurposeDto;
import com.igor1c.portfolio.dto.helpers.ProjectAdditionalPropertyDto;
import com.igor1c.portfolio.entities.AdditionalPropertyEntity;
import com.igor1c.portfolio.entities.AdditionalPropertyValueEntity;
import com.igor1c.portfolio.entities.CategoryEntity;
import com.igor1c.portfolio.entities.DescriptionEntity;
import com.igor1c.portfolio.entities.LanguageEntity;
import com.igor1c.portfolio.entities.MultimediaEntity;
import com.igor1c.portfolio.entities.ProjectCategoryEntity;
import com.igor1c.portfolio.entities.ProjectEntity;
import com.igor1c.portfolio.entities.ProjectPropertyEntity;
import com.igor1c.portfolio.entities.PurposeEntity;
import com.igor1c.portfolio.entities.helpers.ProjectAdditionalProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-25T01:28:03+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public ProjectDto fromEntity(ProjectEntity projectEntity) {
        if ( projectEntity == null ) {
            return null;
        }

        ProjectDto projectDto = new ProjectDto();

        projectDto.setId( projectEntity.getId() );
        projectDto.setName( projectEntity.getName() );
        byte[] imageData = projectEntity.getImageData();
        if ( imageData != null ) {
            projectDto.setImageData( Arrays.copyOf( imageData, imageData.length ) );
        }
        projectDto.setProjectPropertyList( projectPropertyEntityListToProjectPropertyDtoList( projectEntity.getProjectPropertyList() ) );
        projectDto.setProjectAdditionalPropertyMap( map( projectEntity.getProjectAdditionalPropertyMap() ) );
        projectDto.setProjectAdditionalPropertyList( projectAdditionalPropertyListToProjectAdditionalPropertyDtoList( projectEntity.getProjectAdditionalPropertyList() ) );
        projectDto.setProjectCategoryList( projectCategoryEntityListToProjectCategoryDtoList( projectEntity.getProjectCategoryList() ) );
        projectDto.setPurposeList( purposeEntityListToPurposeDtoList( projectEntity.getPurposeList() ) );
        projectDto.setDescriptionList( descriptionEntityListToDescriptionDtoList( projectEntity.getDescriptionList() ) );
        projectDto.setMultimediaList( multimediaEntityListToMultimediaDtoList( projectEntity.getMultimediaList() ) );

        return projectDto;
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

    protected ProjectPropertyDto projectPropertyEntityToProjectPropertyDto(ProjectPropertyEntity projectPropertyEntity) {
        if ( projectPropertyEntity == null ) {
            return null;
        }

        ProjectPropertyDto projectPropertyDto = new ProjectPropertyDto();

        projectPropertyDto.setId( projectPropertyEntity.getId() );
        projectPropertyDto.setPropertyValue( additionalPropertyValueEntityToAdditionalPropertyValueDto( projectPropertyEntity.getPropertyValue() ) );

        return projectPropertyDto;
    }

    protected List<ProjectPropertyDto> projectPropertyEntityListToProjectPropertyDtoList(List<ProjectPropertyEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ProjectPropertyDto> list1 = new ArrayList<ProjectPropertyDto>( list.size() );
        for ( ProjectPropertyEntity projectPropertyEntity : list ) {
            list1.add( projectPropertyEntityToProjectPropertyDto( projectPropertyEntity ) );
        }

        return list1;
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

    protected ProjectAdditionalPropertyDto projectAdditionalPropertyToProjectAdditionalPropertyDto(ProjectAdditionalProperty projectAdditionalProperty) {
        if ( projectAdditionalProperty == null ) {
            return null;
        }

        ProjectAdditionalPropertyDto projectAdditionalPropertyDto = new ProjectAdditionalPropertyDto();

        projectAdditionalPropertyDto.setAdditionalPropertyEntity( additionalPropertyEntityToAdditionalPropertyDto( projectAdditionalProperty.getAdditionalPropertyEntity() ) );
        projectAdditionalPropertyDto.setAdditionalPropertyValueList( additionalPropertyValueEntityListToAdditionalPropertyValueDtoList( projectAdditionalProperty.getAdditionalPropertyValueList() ) );

        return projectAdditionalPropertyDto;
    }

    protected List<ProjectAdditionalPropertyDto> projectAdditionalPropertyListToProjectAdditionalPropertyDtoList(List<ProjectAdditionalProperty> list) {
        if ( list == null ) {
            return null;
        }

        List<ProjectAdditionalPropertyDto> list1 = new ArrayList<ProjectAdditionalPropertyDto>( list.size() );
        for ( ProjectAdditionalProperty projectAdditionalProperty : list ) {
            list1.add( projectAdditionalPropertyToProjectAdditionalPropertyDto( projectAdditionalProperty ) );
        }

        return list1;
    }

    protected CategoryDto categoryEntityToCategoryDto(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( categoryEntity.getId() );
        categoryDto.setName( categoryEntity.getName() );

        return categoryDto;
    }

    protected ProjectCategoryDto projectCategoryEntityToProjectCategoryDto(ProjectCategoryEntity projectCategoryEntity) {
        if ( projectCategoryEntity == null ) {
            return null;
        }

        ProjectCategoryDto projectCategoryDto = new ProjectCategoryDto();

        projectCategoryDto.setId( projectCategoryEntity.getId() );
        projectCategoryDto.setCategory( categoryEntityToCategoryDto( projectCategoryEntity.getCategory() ) );

        return projectCategoryDto;
    }

    protected List<ProjectCategoryDto> projectCategoryEntityListToProjectCategoryDtoList(List<ProjectCategoryEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ProjectCategoryDto> list1 = new ArrayList<ProjectCategoryDto>( list.size() );
        for ( ProjectCategoryEntity projectCategoryEntity : list ) {
            list1.add( projectCategoryEntityToProjectCategoryDto( projectCategoryEntity ) );
        }

        return list1;
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

    protected PurposeDto purposeEntityToPurposeDto(PurposeEntity purposeEntity) {
        if ( purposeEntity == null ) {
            return null;
        }

        PurposeDto purposeDto = new PurposeDto();

        purposeDto.setId( purposeEntity.getId() );
        purposeDto.setLanguage( languageEntityToLanguageDto( purposeEntity.getLanguage() ) );
        purposeDto.setDescription( purposeEntity.getDescription() );
        purposeDto.setListOrder( purposeEntity.getListOrder() );

        return purposeDto;
    }

    protected List<PurposeDto> purposeEntityListToPurposeDtoList(List<PurposeEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<PurposeDto> list1 = new ArrayList<PurposeDto>( list.size() );
        for ( PurposeEntity purposeEntity : list ) {
            list1.add( purposeEntityToPurposeDto( purposeEntity ) );
        }

        return list1;
    }

    protected DescriptionDto descriptionEntityToDescriptionDto(DescriptionEntity descriptionEntity) {
        if ( descriptionEntity == null ) {
            return null;
        }

        DescriptionDto descriptionDto = new DescriptionDto();

        descriptionDto.setId( descriptionEntity.getId() );
        descriptionDto.setLanguage( languageEntityToLanguageDto( descriptionEntity.getLanguage() ) );
        descriptionDto.setShortDescription( descriptionEntity.getShortDescription() );
        descriptionDto.setHtmlShortDescription( descriptionEntity.getHtmlShortDescription() );
        descriptionDto.setDescription( descriptionEntity.getDescription() );
        descriptionDto.setHtmlDescription( descriptionEntity.getHtmlDescription() );

        return descriptionDto;
    }

    protected List<DescriptionDto> descriptionEntityListToDescriptionDtoList(List<DescriptionEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<DescriptionDto> list1 = new ArrayList<DescriptionDto>( list.size() );
        for ( DescriptionEntity descriptionEntity : list ) {
            list1.add( descriptionEntityToDescriptionDto( descriptionEntity ) );
        }

        return list1;
    }

    protected MultimediaDto multimediaEntityToMultimediaDto(MultimediaEntity multimediaEntity) {
        if ( multimediaEntity == null ) {
            return null;
        }

        MultimediaDto multimediaDto = new MultimediaDto();

        multimediaDto.setId( multimediaEntity.getId() );
        multimediaDto.setLanguage( languageEntityToLanguageDto( multimediaEntity.getLanguage() ) );
        byte[] data = multimediaEntity.getData();
        if ( data != null ) {
            multimediaDto.setData( Arrays.copyOf( data, data.length ) );
        }
        multimediaDto.setLink( multimediaEntity.getLink() );

        return multimediaDto;
    }

    protected List<MultimediaDto> multimediaEntityListToMultimediaDtoList(List<MultimediaEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<MultimediaDto> list1 = new ArrayList<MultimediaDto>( list.size() );
        for ( MultimediaEntity multimediaEntity : list ) {
            list1.add( multimediaEntityToMultimediaDto( multimediaEntity ) );
        }

        return list1;
    }
}
