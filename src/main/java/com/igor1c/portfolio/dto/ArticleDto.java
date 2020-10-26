package com.igor1c.portfolio.dto;

import java.util.ArrayList;
import java.util.List;

public class ArticleDto implements BaseDto {
    private Long id;
    private String name;
    private byte[] imageData;
    private List<ArticleContentDto> articleContentList = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

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

    public List<ArticleContentDto> getArticleContentList() {
        return articleContentList;
    }

    public void setArticleContentList(List<ArticleContentDto> articleContentList) {
        this.articleContentList = articleContentList;
    }
}
