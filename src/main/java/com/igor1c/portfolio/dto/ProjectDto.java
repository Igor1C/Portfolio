package com.igor1c.portfolio.dto;

import com.igor1c.portfolio.dto.helpers.ProjectAdditionalPropertyDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectDto implements BaseDto {
    private Long id;
    private String name;
    private byte[] imageData;
    private List<ProjectPropertyDto> projectPropertyList = new ArrayList<>();
    private Map<String, List<AdditionalPropertyValueDto>> projectAdditionalPropertyMap = new HashMap<>();
    private List<ProjectAdditionalPropertyDto> projectAdditionalPropertyList = new ArrayList<>();
    private List<ProjectCategoryDto> projectCategoryList = new ArrayList<>();
    private List<PurposeDto> purposeList = new ArrayList<>();
    private List<DescriptionDto> descriptionList = new ArrayList<>();
    private List<MultimediaDto> multimediaList = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public List<ProjectPropertyDto> getProjectPropertyList() {
        return projectPropertyList;
    }

    public void setProjectPropertyList(List<ProjectPropertyDto> projectPropertyList) {
        this.projectPropertyList = projectPropertyList;
    }

    public Map<String, List<AdditionalPropertyValueDto>> getProjectAdditionalPropertyMap() {
        return projectAdditionalPropertyMap;
    }

    public void setProjectAdditionalPropertyMap(Map<String, List<AdditionalPropertyValueDto>> projectPropertyMap) {
        this.projectAdditionalPropertyMap = projectPropertyMap;
    }

    public List<ProjectAdditionalPropertyDto> getProjectAdditionalPropertyList() {
        return projectAdditionalPropertyList;
    }

    public void setProjectAdditionalPropertyList(List<ProjectAdditionalPropertyDto> projectAdditionalPropertyList) {
        this.projectAdditionalPropertyList = projectAdditionalPropertyList;
    }

    public List<ProjectCategoryDto> getProjectCategoryList() {
        return projectCategoryList;
    }

    public void setProjectCategoryList(List<ProjectCategoryDto> projectCategoryList) {
        this.projectCategoryList = projectCategoryList;
    }

    public List<PurposeDto> getPurposeList() {
        return purposeList;
    }

    public void setPurposeList(List<PurposeDto> purposeList) {
        this.purposeList = purposeList;
    }

    public List<DescriptionDto> getDescriptionList() {
        return descriptionList;
    }

    public void setDescriptionList(List<DescriptionDto> descriptionList) {
        this.descriptionList = descriptionList;
    }

    public List<MultimediaDto> getMultimediaList() {
        return multimediaList;
    }

    public void setMultimediaList(List<MultimediaDto> multimediaList) {
        this.multimediaList = multimediaList;
    }
}
