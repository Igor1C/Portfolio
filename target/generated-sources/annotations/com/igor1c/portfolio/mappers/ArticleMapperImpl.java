package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.ArticleContentDto;
import com.igor1c.portfolio.dto.ArticleDto;
import com.igor1c.portfolio.dto.LanguageDto;
import com.igor1c.portfolio.entities.ArticleContentEntity;
import com.igor1c.portfolio.entities.ArticleEntity;
import com.igor1c.portfolio.entities.LanguageEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-25T01:28:03+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class ArticleMapperImpl implements ArticleMapper {

    @Override
    public ArticleDto fromEntity(ArticleEntity articleEntity) {
        if ( articleEntity == null ) {
            return null;
        }

        ArticleDto articleDto = new ArticleDto();

        articleDto.setId( articleEntity.getId() );
        articleDto.setName( articleEntity.getName() );
        byte[] imageData = articleEntity.getImageData();
        if ( imageData != null ) {
            articleDto.setImageData( Arrays.copyOf( imageData, imageData.length ) );
        }
        articleDto.setArticleContentList( articleContentEntityListToArticleContentDtoList( articleEntity.getArticleContentList() ) );

        return articleDto;
    }

    protected LanguageDto languageEntityToLanguageDto(LanguageEntity languageEntity) {
        if ( languageEntity == null ) {
            return null;
        }

        LanguageDto languageDto = new LanguageDto();

        languageDto.setId( languageEntity.getId() );
        languageDto.setName( languageEntity.getName() );

        return languageDto;
    }

    protected ArticleContentDto articleContentEntityToArticleContentDto(ArticleContentEntity articleContentEntity) {
        if ( articleContentEntity == null ) {
            return null;
        }

        ArticleContentDto articleContentDto = new ArticleContentDto();

        articleContentDto.setId( articleContentEntity.getId() );
        articleContentDto.setLanguage( languageEntityToLanguageDto( articleContentEntity.getLanguage() ) );
        articleContentDto.setTitle( articleContentEntity.getTitle() );
        articleContentDto.setShortDescription( articleContentEntity.getShortDescription() );
        articleContentDto.setHtmlShortDescription( articleContentEntity.getHtmlShortDescription() );
        articleContentDto.setArticleContent( articleContentEntity.getArticleContent() );
        articleContentDto.setHtmlArticleContent( articleContentEntity.getHtmlArticleContent() );

        return articleContentDto;
    }

    protected List<ArticleContentDto> articleContentEntityListToArticleContentDtoList(List<ArticleContentEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<ArticleContentDto> list1 = new ArrayList<ArticleContentDto>( list.size() );
        for ( ArticleContentEntity articleContentEntity : list ) {
            list1.add( articleContentEntityToArticleContentDto( articleContentEntity ) );
        }

        return list1;
    }
}
