package com.igor1c.portfolio.entities;

import com.igor1c.portfolio.helpers.EntityHelper;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = EntityHelper.ADDITIONAL_PROPERTY_VALUE_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class AdditionalPropertyValueEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AdditionalPropertyEntity additionalProperty;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "propertyValue", fetch = FetchType.LAZY)
    private List<ProjectPropertyEntity> projectPropertyList = new ArrayList<>();



    /* CONSTRUCTORS */

    public AdditionalPropertyValueEntity() {
        super(EntityHelper.ADDITIONAL_PROPERTY_VALUE_ENTITY_NAME);
    }

    public AdditionalPropertyValueEntity(AdditionalPropertyEntity additionalProperty, String name) {
        this();
        setAdditionalProperty(additionalProperty);
        setName(name);
    }

    public AdditionalPropertyValueEntity(Long id, AdditionalPropertyEntity additionalProperty, String name) {
        this(additionalProperty, name);
        setId(id);
    }



    /* FUNCTIONAL */

    @Override
    public void lazyInit() {
        Hibernate.initialize(getAdditionalProperty());
        Hibernate.initialize(getProjectPropertyList());
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

    public AdditionalPropertyEntity getAdditionalProperty() {
        return additionalProperty;
    }

    public void setAdditionalProperty(AdditionalPropertyEntity additionalProperty) {
        this.additionalProperty = additionalProperty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    /* GETTERS & SETTERS OF OTHER TABLES */

    public List<ProjectPropertyEntity> getProjectPropertyList() {
        return projectPropertyList;
    }

    public void setProjectPropertyList(List<ProjectPropertyEntity> projectPropertyList) {
        this.projectPropertyList = projectPropertyList;
    }



    /* OBJECT METHODS */

    @Override
    public String toString() {
        return "Additional property value (id=" + getId() + ", additionalProperty=" + getAdditionalProperty().getId() + ", name=\"" + getName() + "\")";
    }
}
