package com.igor1c.portfolio.entities;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.igor1c.portfolio.helpers.EntityHelper;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Entity
@Table(name = EntityHelper.PROJECT_CATEGORY_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class ProjectCategoryEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProjectEntity project;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CategoryEntity category;



    /* CONSTRUCTORS */

    public ProjectCategoryEntity() {
        super(EntityHelper.PROJECT_CATEGORY_ENTITY_NAME);
    }

    public ProjectCategoryEntity(ProjectEntity project, CategoryEntity category) {
        this();
        setProject(project);
        setCategory(category);
    }

    public ProjectCategoryEntity(Long id, ProjectEntity project, CategoryEntity category) {
        this(project, category);
        setId(id);
    }



    /* FUNCTIONAL */

    @Override
    public void lazyInit() {
        Hibernate.initialize(getProject());
        Hibernate.initialize(getCategory());
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

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }



    /* OBJECT METHODS */

    @Override
    public String toString() {
        return "Project category (id=" + getId() + ", project=" + getProject().getId() + ", category=" + getCategory().getId() + ")";
    }
}
