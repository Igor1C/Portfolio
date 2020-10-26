package com.igor1c.portfolio.entities;

import com.igor1c.portfolio.helpers.EntityHelper;
import com.igor1c.portfolio.helpers.HtmlHelper;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = EntityHelper.DESCRIPTION_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class DescriptionEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProjectEntity project;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LanguageEntity language;

    @Column(name = "shortDescription", nullable = false, columnDefinition = "TEXT")
    private String shortDescription;

    @Transient
    private String htmlShortDescription;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Transient
    private String htmlDescription;



    /* CONSTRUCTORS */

    public DescriptionEntity() {
        super(EntityHelper.PURPOSE_ENTITY_NAME);
    }

    public DescriptionEntity(ProjectEntity project, LanguageEntity language, String shortDescription, String description) {
        this();
        setProject(project);
        setLanguage(language);
        setShortDescription(shortDescription);
        setDescription(description);
    }

    public DescriptionEntity(Long id, ProjectEntity project, LanguageEntity language, String shortDescription, String description) {
        this(project, language, shortDescription, description);
        setId(id);
    }



    /* FUNCTIONAL */

    @Override
    public void lazyInit() {
        Hibernate.initialize(getProject());
        Hibernate.initialize(getLanguage());

        setHtmlShortDescription(HtmlHelper.processHtmlString(getShortDescription()));
        setHtmlDescription(HtmlHelper.processHtmlString(getDescription()));
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    /* GETTERS & SETTERS OF NON-TABLE FIELDS */

    public String getHtmlShortDescription() {
        return htmlShortDescription;
    }

    public void setHtmlShortDescription(String htmlShortDescription) {
        this.htmlShortDescription = htmlShortDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }



    /* OBJECT METHODS */

    @Override
    public String toString() {
        return "Description (id=" + getId() + ", project=" + getProject().getId() + ", language=" + getLanguage().getId() + ", shortDescription=\"" + getShortDescription() + "\", description=\"" + getDescription() + "\")";
    }
}
