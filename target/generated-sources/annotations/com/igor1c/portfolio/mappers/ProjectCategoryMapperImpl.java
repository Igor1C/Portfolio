package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.CategoryDto;
import com.igor1c.portfolio.dto.ProjectCategoryDto;
import com.igor1c.portfolio.entities.CategoryEntity;
import com.igor1c.portfolio.entities.ProjectCategoryEntity;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-25T01:28:03+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class ProjectCategoryMapperImpl implements ProjectCategoryMapper {

    @Override
    public ProjectCategoryDto fromEntity(ProjectCategoryEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ProjectCategoryDto projectCategoryDto = new ProjectCategoryDto();

        projectCategoryDto.setId( entity.getId() );
        projectCategoryDto.setCategory( categoryEntityToCategoryDto( entity.getCategory() ) );

        return projectCategoryDto;
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
}
