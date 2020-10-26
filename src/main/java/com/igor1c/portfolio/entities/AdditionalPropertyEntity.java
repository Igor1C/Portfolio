package com.igor1c.portfolio.entities;

import com.igor1c.portfolio.helpers.EntityHelper;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = EntityHelper.ADDITIONAL_PROPERTY_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class AdditionalPropertyEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "additionalProperty", fetch = FetchType.LAZY)
    private List<AdditionalPropertyValueEntity> additionalPropertyValueList = new ArrayList<>();



    /* CONSTRUCTORS */

    public AdditionalPropertyEntity() {
        super(EntityHelper.ADDITIONAL_PROPERTY_ENTITY_NAME);
    }

    public AdditionalPropertyEntity(String name) {
        this();
        setName(name);
    }

    public AdditionalPropertyEntity(Long id, String name) {
        this(name);
        setId(id);
    }



    /* FUNCTIONAL */

    @Override
    public void lazyInit() {
        Hibernate.initialize(getAdditionalPropertyValueList());
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



    /* GETTERS & SETTERS OF OTHER TABLES */

    public List<AdditionalPropertyValueEntity> getAdditionalPropertyValueList() {
        return additionalPropertyValueList;
    }

    public void setAdditionalPropertyValueList(List<AdditionalPropertyValueEntity> additionalPropertyValueList) {
        this.additionalPropertyValueList = additionalPropertyValueList;
    }



    /* OBJECT METHODS */

    @Override
    public String toString() {
        return "Additional property (id=" + getId() + ", name=\"" + getName() + "\")";
    }
}
