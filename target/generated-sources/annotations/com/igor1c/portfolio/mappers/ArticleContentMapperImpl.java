package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.ArticleContentDto;
import com.igor1c.portfolio.dto.LanguageDto;
import com.igor1c.portfolio.entities.ArticleContentEntity;
import com.igor1c.portfolio.entities.LanguageEntity;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-25T01:28:03+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
public class ArticleContentMapperImpl implements ArticleContentMapper {

    @Override
    public ArticleContentDto fromEntity(ArticleContentEntity articleContentEntity) {
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

    protected LanguageDto languageEntityToLanguageDto(LanguageEntity languageEntity) {
        if ( languageEntity == null ) {
            return null;
        }

        LanguageDto languageDto = new LanguageDto();

        languageDto.setId( languageEntity.getId() );
        languageDto.setName( languageEntity.getName() );

        return languageDto;
    }
}
