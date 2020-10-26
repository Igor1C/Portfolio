package com.igor1c.portfolio.entities;

import com.igor1c.portfolio.helpers.EntityHelper;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Entity
@Table(name = EntityHelper.PROJECT_PROPERTY_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class ProjectPropertyEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProjectEntity project;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AdditionalPropertyValueEntity propertyValue;

    @Transient
    private AdditionalPropertyEntity additionalProperty;



    /* CONSTRUCTORS */

    public ProjectPropertyEntity() {
        super(EntityHelper.PROJECT_PROPERTY_ENTITY_NAME);
    }

    public ProjectPropertyEntity(ProjectEntity project, AdditionalPropertyValueEntity propertyValue) {
        this();
        setProject(project);
        setPropertyValue(propertyValue);
    }

    public ProjectPropertyEntity(Long id, ProjectEntity project, AdditionalPropertyValueEntity propertyValue) {
        this(project, propertyValue);
        setId(id);
    }



    /* FUNCTIONAL */

    @Override
    public void lazyInit() {
        Hibernate.initialize(getPropertyValue());

        processAdditionalProperty();
    }

    private void processAdditionalProperty() {
        setAdditionalProperty(propertyValue.getAdditionalProperty());
    }



    /* GETTERS & SETTERS */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public AdditionalPropertyValueEntity getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(AdditionalPropertyValueEntity propertyValue) {
        this.propertyValue = propertyValue;
        processAdditionalProperty();
    }



    /* GETTERS & SETTERS OF NON-TABLE FIELDS */

    public AdditionalPropertyEntity getAdditionalProperty() {
        return additionalProperty;
    }

    public void setAdditionalProperty(AdditionalPropertyEntity additionalProperty) {
        this.additionalProperty = additionalProperty;
    }



    /* OBJECT METHODS */

    @Override
    public String toString() {
        return "Project property (id=" + getId() + ", project=" + getProject().getId() + ", propertyValue=" + getPropertyValue().getId() + ")";
    }
}
