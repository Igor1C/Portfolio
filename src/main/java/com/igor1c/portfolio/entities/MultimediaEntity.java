package com.igor1c.portfolio.entities;

import com.igor1c.portfolio.helpers.EntityHelper;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Entity
@Table(name = EntityHelper.MULTIMEDIA_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class MultimediaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProjectEntity project;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LanguageEntity language;

    @Column(name = "data")
    private byte[] data;

    @Column(name = "link")
    private String link;


    /* CONSTRUCTORS */

    public MultimediaEntity() {
        super(EntityHelper.PURPOSE_ENTITY_NAME);
    }

    public MultimediaEntity(ProjectEntity project, LanguageEntity language, byte[] data, String link) {
        this();
        setProject(project);
        setLanguage(language);
        setData(data);
        setLink(link);
    }

    public MultimediaEntity(Long id, ProjectEntity project, LanguageEntity language, byte[] data, String link) {
        this(project, language, data, link);
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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }



    /* OBJECT METHODS */

    @Override
    public String toString() {
        return "Multimedia (id=" + getId() + ", project=" + getProject().getId() + ", link=\"" + getLink() + "\")";
    }
}
