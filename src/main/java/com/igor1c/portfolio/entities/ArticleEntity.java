package com.igor1c.portfolio.entities;

import com.igor1c.portfolio.helpers.EntityHelper;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = EntityHelper.ARTICLE_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class ArticleEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "imageData")
    private byte[] imageData;

    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
    private List<ArticleContentEntity> articleContentList = new ArrayList<>();



    /* CONSTRUCTORS */

    public ArticleEntity() {
        super(EntityHelper.ARTICLE_ENTITY_NAME);
    }

    public ArticleEntity(String name, byte[] imageData) {
        this();
        setName(name);
        setImageData(imageData);
    }

    public ArticleEntity(Long id, String name, byte[] imageData) {
        this(name, imageData);
        setId(id);
    }



    /* FUNCTIONAL */

    @Override
    public void lazyInit() {
        Hibernate.initialize(getArticleContentList());

        processArticleContentList();
    }

    private void processArticleContentList() {
        getArticleContentList().stream().forEach(ArticleContentEntity::lazyInit);
    }



    /* FILTRATION */

    public void filterByLanguage(LanguageEntity languageEntity) {
        setArticleContentList(getArticleContentList().stream().filter(entity -> entity.getLanguage() == languageEntity).collect(Collectors.toList()));
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

    public List<ArticleContentEntity> getArticleContentList() {
        return articleContentList;
    }

    public void setArticleContentList(List<ArticleContentEntity> articleContentList) {
        this.articleContentList = articleContentList;
    }



    /* OBJECT METHODS */

    @Override
    public String toString() {
        return "Article (id=" + getId() + ", name=\"" + getName() + "\")";
    }
}
