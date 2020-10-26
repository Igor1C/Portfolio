package com.igor1c.portfolio.entities;

import com.igor1c.portfolio.dto.helpers.FilterOptions;
import com.igor1c.portfolio.dto.helpers.ProjectAdditionalPropertyDto;
import com.igor1c.portfolio.entities.helpers.ProjectAdditionalProperty;
import com.igor1c.portfolio.helpers.CollectionsHelper;
import com.igor1c.portfolio.helpers.EntityHelper;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name = EntityHelper.PROJECT_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class ProjectEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "imageData")
    private byte[] imageData;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<ProjectPropertyEntity> projectPropertyList = new ArrayList<>();

    @Transient
    private Map<AdditionalPropertyEntity, List<AdditionalPropertyValueEntity>> projectAdditionalPropertyMap = new HashMap<>();

    @Transient
    private List<ProjectAdditionalProperty> projectAdditionalPropertyList = new ArrayList<>();

    @Transient
    private List<Long> additionalPropertyIdList = new ArrayList<>();

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<ProjectCategoryEntity> projectCategoryList = new ArrayList<>();

    @Transient
    private List<Long> categoryIdList = new ArrayList<>();

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<PurposeEntity> purposeList = new ArrayList<>();

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<DescriptionEntity> descriptionList = new ArrayList<>();

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<MultimediaEntity> multimediaList = new ArrayList<>();



    /* CONSTRUCTORS */

    public ProjectEntity() {
        super(EntityHelper.PROJECT_ENTITY_NAME);
    }

    public ProjectEntity(String name, byte[] imageData) {
        this();
        setName(name);
        setImageData(imageData);
    }

    public ProjectEntity(Long id, String name, byte[] imageData) {
        this(name, imageData);
        setId(id);
    }



    /* FUNCTIONAL */

    @Override
    public void lazyInit() {
        Hibernate.initialize(getProjectPropertyList());
        Hibernate.initialize(getProjectCategoryList());
        Hibernate.initialize(getPurposeList());
        Hibernate.initialize(getDescriptionList());
        Hibernate.initialize(getMultimediaList());

        processProjectProperties();
        processProjectCategories();
        processDescriptions();
    }

    private void processProjectProperties() {
        List<Long> additionalPropertyIdList = new ArrayList<>();
        getProjectPropertyList().stream().forEach(projectProperty -> {
            projectProperty.lazyInit();
            additionalPropertyIdList.add(projectProperty.getPropertyValue().getId());
        });
        setAdditionalPropertyIdList(additionalPropertyIdList);

        setProjectAdditionalPropertyMap(
                ProjectAdditionalProperty.getProjectAdditionalPropertyMapFromProjectPropertyList(getProjectPropertyList()));

        setProjectAdditionalPropertyList(
                ProjectAdditionalProperty.getProjectAdditionalPropertyList(getProjectAdditionalPropertyMap()));
    }

    private void processProjectCategories() {
        List<Long> categoryIdList = new ArrayList<>();
        getProjectCategoryList().forEach(e -> {
            e.lazyInit();
            categoryIdList.add(e.getCategory().getId());
        });
        setCategoryIdList(categoryIdList);
    }

    private void processDescriptions() {
        getDescriptionList().stream().forEach(DescriptionEntity::lazyInit);
    }



    /* FILTRATION */

    public void filterByLanguage(LanguageEntity languageEntity) {
        setPurposeList(getPurposeList().stream().filter(entity -> entity.getLanguage() == languageEntity).collect(Collectors.toList()));
        setDescriptionList(getDescriptionList().stream().filter(entity -> entity.getLanguage() == languageEntity).collect(Collectors.toList()));
        setMultimediaList(getMultimediaList().stream().filter(entity -> entity.getLanguage() == languageEntity).collect(Collectors.toList()));
    }

    public static List<ProjectEntity> filterByFilterOptions(List<ProjectEntity> projectEntityList, FilterOptions filterOptions) {
        Stream<ProjectEntity> stream = projectEntityList.stream();
        stream = filterStreamByCategories(stream, filterOptions);
        stream = filterStreamByProperties(stream, filterOptions);

        return stream.collect(Collectors.toList());
    }

    private static Stream<ProjectEntity> filterStreamByCategories(Stream<ProjectEntity> stream, FilterOptions filterOptions) {
        List<Long> categoryIdList = CollectionsHelper.getSelectedIdList(filterOptions.getCategories());
        if (categoryIdList.size() == 0) {
            return stream;
        }

        Stream<ProjectEntity> resultStream = stream.filter(projectEntity ->
                CollectionsHelper.listsHaveCrossing(projectEntity.getCategoryIdList(), categoryIdList)
        );

        return resultStream;
    }

    private static Stream<ProjectEntity> filterStreamByProperties(Stream<ProjectEntity> stream, FilterOptions filterOptions) {
        for (ProjectAdditionalPropertyDto property : filterOptions.getProperties()) {
            final List<Long> propertyIdList = CollectionsHelper.getSelectedIdList(property.getAdditionalPropertyValueList());
            if (propertyIdList.size() == 0) {
                continue;
            }

            stream = stream.filter(projectEntity ->
                    CollectionsHelper.listsHaveCrossing(projectEntity.getAdditionalPropertyIdList(), propertyIdList));
        }

        return stream;
    }

    // Should be called after filtration by language.
    public void limitMultimediaData(int limitSize) {
        setMultimediaList(getMultimediaList().stream().filter(multimediaEntity ->
                multimediaEntity.getData() != null).limit(limitSize).collect(Collectors.toList()));
    }



    /* GETTERS & SETTERS */

    @Override
    public Long getId() {
        return id;
    }

    @Override
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



    /* GETTERS & SETTERS OF OTHER TABLES */

    public List<ProjectPropertyEntity> getProjectPropertyList() {
        return projectPropertyList;
    }

    public void setProjectPropertyList(List<ProjectPropertyEntity> projectPropertyList) {
        this.projectPropertyList = projectPropertyList;
        processProjectProperties();
    }

    public List<ProjectCategoryEntity> getProjectCategoryList() {
        return projectCategoryList;
    }

    public void setProjectCategoryList(List<ProjectCategoryEntity> projectCategoryList) {
        this.projectCategoryList = projectCategoryList;
        processProjectCategories();
    }

    public List<Long> getCategoryIdList() {
        return categoryIdList;
    }

    public void setCategoryIdList(List<Long> categoryIdList) {
        this.categoryIdList = categoryIdList;
    }

    public List<PurposeEntity> getPurposeList() {
        return purposeList;
    }

    public void setPurposeList(List<PurposeEntity> purposeList) {
        this.purposeList = purposeList;
    }

    public List<DescriptionEntity> getDescriptionList() {
        return descriptionList;
    }

    public void setDescriptionList(List<DescriptionEntity> descriptionList) {
        this.descriptionList = descriptionList;
    }

    public List<MultimediaEntity> getMultimediaList() {
        return multimediaList;
    }

    public void setMultimediaList(List<MultimediaEntity> multimediaList) {
        this.multimediaList = multimediaList;
    }



    /* GETTERS & SETTERS OF NON-TABLE FIELDS */

    public Map<AdditionalPropertyEntity, List<AdditionalPropertyValueEntity>> getProjectAdditionalPropertyMap() {
        return projectAdditionalPropertyMap;
    }

    public void setProjectAdditionalPropertyMap(Map<AdditionalPropertyEntity, List<AdditionalPropertyValueEntity>> projectPropertyMap) {
        this.projectAdditionalPropertyMap = projectPropertyMap;
    }

    public List<ProjectAdditionalProperty> getProjectAdditionalPropertyList() {
        return projectAdditionalPropertyList;
    }

    public void setProjectAdditionalPropertyList(List<ProjectAdditionalProperty> projectAdditionalPropertyList) {
        this.projectAdditionalPropertyList = projectAdditionalPropertyList;
    }

    public List<Long> getAdditionalPropertyIdList() {
        return additionalPropertyIdList;
    }

    public void setAdditionalPropertyIdList(List<Long> additionalPropertyIdList) {
        this.additionalPropertyIdList = additionalPropertyIdList;
    }



    /* OBJECT METHODS */

    @Override
    public String toString() {
        return "Project (id=" + getId() + ", name=\"" + getName() + "\")";
    }
}
