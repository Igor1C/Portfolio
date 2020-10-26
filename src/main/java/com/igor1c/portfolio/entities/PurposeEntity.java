package com.igor1c.portfolio.entities;

import com.igor1c.portfolio.helpers.EntityHelper;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Entity
@Table(name = EntityHelper.PURPOSE_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class PurposeEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProjectEntity project;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LanguageEntity language;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "listOrder", nullable = false)
    private Integer listOrder;



    /* CONSTRUCTORS */

    public PurposeEntity() {
        super(EntityHelper.PURPOSE_ENTITY_NAME);
    }

    public PurposeEntity(ProjectEntity project, LanguageEntity language, String description, Integer listOrder) {
        this();
        setProject(project);
        setLanguage(language);
        setDescription(description);
        setListOrder(listOrder);
    }

    public PurposeEntity(Long id, ProjectEntity project, LanguageEntity language, String description, Integer listOrder) {
        this(project, language, description, listOrder);
        setId(id);
    }



    /* FUNCTIONAL */

    @Override
    public void lazyInit() {
        Hibernate.initialize(getProject());
        Hibernate.initialize(getLanguage());
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

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getListOrder() {
        return listOrder;
    }

    public void setListOrder(Integer listOrder) {
        this.listOrder = listOrder;
    }



    /* OBJECT METHODS */

    @Override
    public String toString() {
        return "Purpose (id=" + getId() + ", project=" + getProject().getId() + ", language=" + getLanguage().getId() + ", description=\"" + getDescription() + "\", order=" + getListOrder() + ")";
    }
}
