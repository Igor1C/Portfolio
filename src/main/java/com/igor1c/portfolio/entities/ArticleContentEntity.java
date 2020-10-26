package com.igor1c.portfolio.entities;

import com.igor1c.portfolio.helpers.EntityHelper;
import com.igor1c.portfolio.helpers.HtmlHelper;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Entity
@Table(name = EntityHelper.ARTICLE_CONTENT_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class ArticleContentEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ArticleEntity article;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LanguageEntity language;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "shortDescription", nullable = false, columnDefinition = "TEXT")
    private String shortDescription;

    @Transient
    private String htmlShortDescription;

    @Column(name = "articleContent", nullable = false, columnDefinition = "TEXT")
    private String articleContent;

    @Transient
    private String htmlArticleContent;



    /* CONSTRUCTORS */

    public ArticleContentEntity() {
        super(EntityHelper.ARTICLE_CONTENT_ENTITY_NAME);
    }

    public ArticleContentEntity(ArticleEntity article, LanguageEntity language, String title, String shortDescription, String articleContent) {
        this();
        setArticle(article);
        setLanguage(language);
        setTitle(title);
        setShortDescription(shortDescription);
        setArticleContent(articleContent);
    }

    public ArticleContentEntity(Long id, ArticleEntity article, LanguageEntity language, String title, String shortDescription, String articleContent) {
        this(article, language, title, shortDescription, articleContent);
        setId(id);
    }



    /* FUNCTIONAL */

    @Override
    public void lazyInit() {
        Hibernate.initialize(getArticle());
        Hibernate.initialize(getLanguage());

        setHtmlShortDescription(HtmlHelper.processHtmlString(getShortDescription()));
        setHtmlArticleContent(HtmlHelper.processHtmlString(getArticleContent()));
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

    public ArticleEntity getArticle() {
        return article;
    }

    public void setArticle(ArticleEntity article) {
        this.article = article;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }



    /* GETTERS & SETTERS OF NON-TABLE FIELDS */

    public String getHtmlShortDescription() {
        return htmlShortDescription;
    }

    public void setHtmlShortDescription(String htmlShortDescription) {
        this.htmlShortDescription = htmlShortDescription;
    }

    public String getHtmlArticleContent() {
        return htmlArticleContent;
    }

    public void setHtmlArticleContent(String htmlArticleContent) {
        this.htmlArticleContent = htmlArticleContent;
    }



    /* OBJECT METHODS */

    @Override
    public String toString() {
        return "Article content (id=" + getId() + ", article=" + getArticle().getId() + ", language=" + getLanguage().getId() + ", name=" + getTitle() + ", shortDescription=\"" + getShortDescription() + "\", articleContent=\"" + getArticleContent() + "\")";
    }
}
