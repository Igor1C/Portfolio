package com.igor1c.portfolio.dto;

public class ProjectCategoryDto implements BaseDto {
    private Long id;
    private CategoryDto category;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }
}
