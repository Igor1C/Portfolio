package com.igor1c.portfolio.entities.helpers;

import com.igor1c.portfolio.entities.AdditionalPropertyEntity;
import com.igor1c.portfolio.entities.AdditionalPropertyValueEntity;
import com.igor1c.portfolio.entities.ProjectPropertyEntity;
import com.igor1c.portfolio.helpers.ApplicationContextProvider;
import com.igor1c.portfolio.repositories.AdditionalPropertyValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class is used as helper class. It maps Additional properties and Project properties.
 * Class isn't a part of database.
 */
public class ProjectAdditionalProperty {

    @Autowired
    private static ApplicationContextProvider acp;
    private static ApplicationContext context = acp.getApplicationContext();
    private static AdditionalPropertyValueRepository additionalPropertyValueRepository = context.getBean(AdditionalPropertyValueRepository.class);

    AdditionalPropertyEntity additionalPropertyEntity;
    List<AdditionalPropertyValueEntity> additionalPropertyValueList = new ArrayList<>();



    /* CONSTRUCTORS */

    public ProjectAdditionalProperty() {
    }

    public ProjectAdditionalProperty(AdditionalPropertyEntity additionalPropertyEntity, List<AdditionalPropertyValueEntity> additionalPropertyValueList) {
        this.additionalPropertyEntity = additionalPropertyEntity;
        this.additionalPropertyValueList = additionalPropertyValueList;
    }



    /* FUNCTIONAL */

    public static Map<AdditionalPropertyEntity, List<AdditionalPropertyValueEntity>> getProjectAdditionalPropertyMapFromProjectPropertyList(List<ProjectPropertyEntity> projectPropertyList) {
        return projectPropertyList.stream()
                .collect(
                        Collectors.groupingBy(ProjectPropertyEntity::getAdditionalProperty,
                                Collectors.mapping(ProjectPropertyEntity::getPropertyValue, Collectors.toList())));
    }

    public static Map<AdditionalPropertyEntity, List<AdditionalPropertyValueEntity>> getProjectAdditionalPropertyMapFromAdditionalPropertyValueList(List<AdditionalPropertyValueEntity> additionalPropertyValueList) {
        return additionalPropertyValueList.stream()
                .collect(
                        Collectors.groupingBy(AdditionalPropertyValueEntity::getAdditionalProperty,
                                Collectors.mapping(AdditionalPropertyValueEntity -> AdditionalPropertyValueEntity, Collectors.toList())));
    }

    public static List<ProjectAdditionalProperty> getProjectAdditionalPropertyList(Map<AdditionalPropertyEntity, List<AdditionalPropertyValueEntity>> projectAdditionalPropertyMap) {
        List<ProjectAdditionalProperty> projectAdditionalPropertyList = new ArrayList<>();

        projectAdditionalPropertyMap.entrySet().stream().forEach(entry -> {
            ProjectAdditionalProperty projectAdditionalProperty = new ProjectAdditionalProperty();
            projectAdditionalProperty.setAdditionalPropertyEntity(entry.getKey());
            projectAdditionalProperty.setAdditionalPropertyValueList(entry.getValue());
            projectAdditionalPropertyList.add(projectAdditionalProperty);
        });

        return projectAdditionalPropertyList;
    }

    public static List<ProjectAdditionalProperty> getAllProjectAdditionalPropertyList() {
        return getProjectAdditionalPropertyList(
                getProjectAdditionalPropertyMapFromAdditionalPropertyValueList(
                        additionalPropertyValueRepository.findAll()));
    }



    /* GETTERS & SETTERS */

    public AdditionalPropertyEntity getAdditionalPropertyEntity() {
        return additionalPropertyEntity;
    }

    public void setAdditionalPropertyEntity(AdditionalPropertyEntity additionalPropertyEntity) {
        this.additionalPropertyEntity = additionalPropertyEntity;
    }

    public List<AdditionalPropertyValueEntity> getAdditionalPropertyValueList() {
        return additionalPropertyValueList;
    }

    public void setAdditionalPropertyValueList(List<AdditionalPropertyValueEntity> additionalPropertyValueList) {
        this.additionalPropertyValueList = additionalPropertyValueList;
    }
}
