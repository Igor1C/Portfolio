package com.igor1c.portfolio.dto;

public class ArticleContentDto implements BaseDto {
    private Long id;
    private LanguageDto language;
    private String title;
    private String shortDescription;
    private String htmlShortDescription;
    private String articleContent;
    private String htmlArticleContent;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LanguageDto getLanguage() {
        return language;
    }

    public void setLanguage(LanguageDto language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getHtmlShortDescription() {
        return htmlShortDescription;
    }

    public void setHtmlShortDescription(String htmlShortDescription) {
        this.htmlShortDescription = htmlShortDescription;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getHtmlArticleContent() {
        return htmlArticleContent;
    }

    public void setHtmlArticleContent(String htmlArticleContent) {
        this.htmlArticleContent = htmlArticleContent;
    }
}
