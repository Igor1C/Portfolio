package com.igor1c.portfolio.controllers;

import com.igor1c.portfolio.dto.LanguageDto;
import com.igor1c.portfolio.entities.LanguageEntity;
import com.igor1c.portfolio.helpers.ApplicationContextProvider;
import com.igor1c.portfolio.mappers.LanguageMapper;
import com.igor1c.portfolio.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("language")
public class LanguageController {

    @Autowired
    private ApplicationContextProvider acp;
    private ApplicationContext context;

    private final LanguageRepository languageRepository;



    /* CONSTRUCTORS */

    public LanguageController() {
        context = acp.getApplicationContext();
        languageRepository = context.getBean(LanguageRepository.class);
    }



    /* CRUD METHODS */

    @GetMapping("/getAll")
    @Transactional
    public List<LanguageDto> getAll() {
        List<LanguageEntity> languageEntityList = languageRepository.findAll();
        List<LanguageDto> languageDtoList = new ArrayList<>();
        languageEntityList.stream().forEach((entity) -> {
            languageDtoList.add(LanguageMapper.INSTANCE.fromEntity(entity));
        });
        return languageDtoList;
    }
}
