package com.igor1c.portfolio.entities;

import com.igor1c.portfolio.helpers.EntityHelper;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = EntityHelper.CATEGORY_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class CategoryEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<ProjectCategoryEntity> projectCategoryList = new ArrayList<>();



    /* CONSTRUCTORS */

    public CategoryEntity() {
        super(EntityHelper.CATEGORY_ENTITY_NAME);
    }

    public CategoryEntity(String name) {
        this();
        setName(name);
    }

    public CategoryEntity(String entityName, Long id, String name) {
        this(name);
        setId(id);
    }



    /* FUNCTIONAL */

    @Override
    public void lazyInit() {
        Hibernate.initialize(getProjectCategoryList());
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

    public List<ProjectCategoryEntity> getProjectCategoryList() {
        return projectCategoryList;
    }

    public void setProjectCategoryList(List<ProjectCategoryEntity> projectCategoryList) {
        this.projectCategoryList = projectCategoryList;
    }



    /* OBJECT METHODS */

    @Override
    public String toString() {
        return "Category (id=" + getId() + ", name=\"" + getName() + "\")";
    }
}
