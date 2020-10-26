package com.igor1c.portfolio.dto;

public class ProjectPropertyDto implements BaseDto {
    private Long id;
    private AdditionalPropertyValueDto propertyValue;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AdditionalPropertyValueDto getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(AdditionalPropertyValueDto propertyValue) {
        this.propertyValue = propertyValue;
    }
}
