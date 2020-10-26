package com.igor1c.portfolio.dto.helpers;

import com.igor1c.portfolio.dto.AdditionalPropertyDto;
import com.igor1c.portfolio.dto.AdditionalPropertyValueDto;

import java.util.ArrayList;
import java.util.List;

public class ProjectAdditionalPropertyDto {
    AdditionalPropertyDto additionalPropertyEntity;
    List<AdditionalPropertyValueDto> additionalPropertyValueList = new ArrayList<>();

    public AdditionalPropertyDto getAdditionalPropertyEntity() {
        return additionalPropertyEntity;
    }

    public void setAdditionalPropertyEntity(AdditionalPropertyDto additionalPropertyEntity) {
        this.additionalPropertyEntity = additionalPropertyEntity;
    }

    public List<AdditionalPropertyValueDto> getAdditionalPropertyValueList() {
        return additionalPropertyValueList;
    }

    public void setAdditionalPropertyValueList(List<AdditionalPropertyValueDto> additionalPropertyValueList) {
        this.additionalPropertyValueList = additionalPropertyValueList;
    }
}
