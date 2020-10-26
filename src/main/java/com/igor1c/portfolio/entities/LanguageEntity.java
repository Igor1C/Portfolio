package com.igor1c.portfolio.entities;

import com.igor1c.portfolio.helpers.EntityHelper;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = EntityHelper.LANGUAGE_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class LanguageEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "language", fetch = FetchType.LAZY)
    private List<PurposeEntity> purposeList = new ArrayList<>();

    @OneToMany(mappedBy = "language", fetch = FetchType.LAZY)
    private List<DescriptionEntity> descriptionList = new ArrayList<>();

    @OneToMany(mappedBy = "language", fetch = FetchType.LAZY)
    private List<MultimediaEntity> multimediaList = new ArrayList<>();

    @OneToMany(mappedBy = "language", fetch = FetchType.LAZY)
    private List<ArticleContentEntity> articleContentList = new ArrayList<>();



    /* CONSTRUCTORS */

    public LanguageEntity() {
        super(EntityHelper.LANGUAGE_ENTITY_NAME);
    }

    public LanguageEntity(String name) {
        this();
        setName(name);
    }

    public LanguageEntity(Long id, String name) {
        this(name);
        setId(id);
    }



    /* FUNCTIONAL */

    @Override
    public void lazyInit() {
        Hibernate.initialize(getPurposeList());
        Hibernate.initialize(getDescriptionList());
        Hibernate.initialize(getMultimediaList());
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

    public List<ArticleContentEntity> getArticleContentList() {
        return articleContentList;
    }

    public void setArticleContentList(List<ArticleContentEntity> articleContentList) {
        this.articleContentList = articleContentList;
    }



    /* OBJECT METHODS */

    @Override
    public String toString() {
        return "Language (id=" + getId() + ", name=\"" + getName() + "\")";
    }
}
