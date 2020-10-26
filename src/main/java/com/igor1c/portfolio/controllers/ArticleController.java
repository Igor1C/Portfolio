package com.igor1c.portfolio.controllers;

import com.igor1c.portfolio.dto.ArticleDto;
import com.igor1c.portfolio.entities.ArticleEntity;
import com.igor1c.portfolio.entities.LanguageEntity;
import com.igor1c.portfolio.helpers.ApplicationContextProvider;
import com.igor1c.portfolio.mappers.ArticleMapper;
import com.igor1c.portfolio.repositories.ArticleRepository;
import com.igor1c.portfolio.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ApplicationContextProvider acp;
    private ApplicationContext context;

    private final ArticleRepository articleRepository;
    private final LanguageRepository languageRepository;


    /* CONSTRUCTORS */

    public ArticleController() {
        context = acp.getApplicationContext();
        articleRepository = context.getBean(ArticleRepository.class);
        languageRepository = context.getBean(LanguageRepository.class);
    }



    /* CRUD METHODS OF THE ARTICLE */

    @GetMapping("/getAll")
    @Transactional
    public List<ArticleDto> getAll(@RequestParam String language) {
        List<ArticleDto> articleDtoList = new ArrayList<>();

        getAllAndFilterByLanguage(language).forEach(articleEntity ->
                articleDtoList.add(ArticleMapper.INSTANCE.fromEntity(articleEntity))
        );

        return articleDtoList;
    }

    private List<ArticleEntity> getAllAndFilterByLanguage(String language) {
        LanguageEntity languageEntity = languageRepository.findByName(language);
        List<ArticleEntity> articleEntityList = articleRepository.findAll();
        articleEntityList.forEach((articleEntity) -> {
            articleEntity.filterByLanguage(languageEntity);
            articleEntity.lazyInit();
        });

        return articleEntityList;
    }

    @GetMapping("")
    @Transactional
    public ArticleDto get(@RequestParam String name, @RequestParam String language) {
        LanguageEntity languageEntity = languageRepository.findByName(language);

        ArticleEntity articleEntity = articleRepository.findByName(name).get(0);
        articleEntity.filterByLanguage(languageEntity);
        articleEntity.lazyInit();

        return ArticleMapper.INSTANCE.fromEntity(articleEntity);
    }
}
