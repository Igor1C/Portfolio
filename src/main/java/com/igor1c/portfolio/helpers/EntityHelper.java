package com.igor1c.portfolio.helpers;

import com.igor1c.portfolio.entities.BaseEntity;
import com.igor1c.portfolio.entities.CategoryEntity;
import com.igor1c.portfolio.entities.PurposeEntity;
import com.igor1c.portfolio.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EntityHelper {

    @Autowired
    private static ApplicationContextProvider acp;
    private static ApplicationContext context = acp.getApplicationContext();

    public static final String PROJECT_ENTITY_NAME = "project";
    public static final String ADDITIONAL_PROPERTY_ENTITY_NAME = "additionalProperty";
    public static final String ADDITIONAL_PROPERTY_VALUE_ENTITY_NAME = "additionalPropertyValue";
    public static final String PROJECT_PROPERTY_ENTITY_NAME = "projectProperty";
    public static final String CATEGORY_ENTITY_NAME = "category";
    public static final String PROJECT_CATEGORY_ENTITY_NAME = "projectCategory";
    public static final String PURPOSE_ENTITY_NAME = "purpose";
    public static final String DESCRIPTION_ENTITY_NAME = "description";
    public static final String MULTIMEDIA_ENTITY_NAME = "multimedia";
    public static final String LANGUAGE_ENTITY_NAME = "language";
    public static final String ARTICLE_ENTITY_NAME = "article";
    public static final String ARTICLE_CONTENT_ENTITY_NAME = "articleContent";

    public static final String PROJECT_TABLE_NAME = "projects";
    public static final String ADDITIONAL_PROPERTY_TABLE_NAME = "additionalProperties";
    public static final String ADDITIONAL_PROPERTY_VALUE_TABLE_NAME = "additionalPropertyValues";
    public static final String PROJECT_PROPERTY_TABLE_NAME = "projectProperties";
    public static final String CATEGORY_TABLE_NAME = "categories";
    public static final String PROJECT_CATEGORY_TABLE_NAME = "projectCategories";
    public static final String PURPOSE_TABLE_NAME = "purposes";
    public static final String DESCRIPTION_TABLE_NAME = "descriptions";
    public static final String MULTIMEDIA_TABLE_NAME = "multimedia";
    public static final String LANGUAGE_TABLE_NAME = "languages";
    public static final String ARTICLE_TABLE_NAME = "articles";
    public static final String ARTICLE_CONTENT_TABLE_NAME = "articleContents";



    public static CrudRepository getRepository(BaseEntity entity) {
        switch (entity.getEntityName()) {
            case PROJECT_ENTITY_NAME:
                return context.getBean(ProjectRepository.class);
            case ADDITIONAL_PROPERTY_ENTITY_NAME:
                return context.getBean(AdditionalPropertyRepository.class);
            case ADDITIONAL_PROPERTY_VALUE_ENTITY_NAME:
                return context.getBean(AdditionalPropertyValueRepository.class);
            case PROJECT_PROPERTY_ENTITY_NAME:
                return context.getBean(ProjectPropertyRepository.class);
            case CATEGORY_ENTITY_NAME:
                return context.getBean(CategoryRepository.class);
            case PROJECT_CATEGORY_ENTITY_NAME:
                return context.getBean(ProjectCategoryRepository.class);
            case PURPOSE_ENTITY_NAME:
                return context.getBean(PurposeRepository.class);
            case DESCRIPTION_ENTITY_NAME:
                return context.getBean(DescriptionRepository.class);
            case MULTIMEDIA_ENTITY_NAME:
                return context.getBean(MultimediaRepository.class);
            case LANGUAGE_ENTITY_NAME:
                return context.getBean(LanguageRepository.class);
            case ARTICLE_ENTITY_NAME:
                return context.getBean(ArticleRepository.class);
            case ARTICLE_CONTENT_ENTITY_NAME:
                return context.getBean(ArticleContentRepository.class);
            default:
                return null;
        }
    }

    public static void getRepositoryAndSave(BaseEntity entity) {
        getRepository(entity).save(entity);
    }

    public static int getRelationOrder(BaseEntity entity) {
        switch (entity.getEntityName()) {
            case PROJECT_ENTITY_NAME:
                return 12;
            case ADDITIONAL_PROPERTY_ENTITY_NAME:
                return 11;
            case ADDITIONAL_PROPERTY_VALUE_ENTITY_NAME:
                return 10;
            case PROJECT_PROPERTY_ENTITY_NAME:
                return 9;
            case CATEGORY_ENTITY_NAME:
                return 8;
            case PROJECT_CATEGORY_ENTITY_NAME:
                return 7;
            case PURPOSE_ENTITY_NAME:
                return 3;
            case DESCRIPTION_ENTITY_NAME:
                return 2;
            case MULTIMEDIA_ENTITY_NAME:
                return 1;
            case LANGUAGE_ENTITY_NAME:
                return 6;
            case ARTICLE_ENTITY_NAME:
                return 5;
            case ARTICLE_CONTENT_ENTITY_NAME:
                return 4;
            default:
                return 13;
        }
    }

    // Repositories are in the relation order (for clearing tables).
    public static List<JpaRepository> getRepositories() {
        List<JpaRepository> jpaRepositoryList = new ArrayList<>();
        jpaRepositoryList.add(context.getBean(MultimediaRepository.class));
        jpaRepositoryList.add(context.getBean(DescriptionRepository.class));
        jpaRepositoryList.add(context.getBean(PurposeRepository.class));
        jpaRepositoryList.add(context.getBean(ArticleContentRepository.class));
        jpaRepositoryList.add(context.getBean(ArticleRepository.class));
        jpaRepositoryList.add(context.getBean(LanguageRepository.class));
        jpaRepositoryList.add(context.getBean(ProjectCategoryRepository.class));
        jpaRepositoryList.add(context.getBean(CategoryRepository.class));
        jpaRepositoryList.add(context.getBean(ProjectPropertyRepository.class));
        jpaRepositoryList.add(context.getBean(AdditionalPropertyValueRepository.class));
        jpaRepositoryList.add(context.getBean(AdditionalPropertyRepository.class));
        jpaRepositoryList.add(context.getBean(ProjectRepository.class));

        return jpaRepositoryList;
    }

    // Tables are in the relation order (for deleting tables).
    public static List<String> getTableNames() {
        List<String> tableNameList = new ArrayList<>();
        tableNameList.add(MULTIMEDIA_TABLE_NAME);
        tableNameList.add(DESCRIPTION_TABLE_NAME);
        tableNameList.add(PURPOSE_TABLE_NAME);
        tableNameList.add(ARTICLE_CONTENT_TABLE_NAME);
        tableNameList.add(ARTICLE_TABLE_NAME);
        tableNameList.add(LANGUAGE_TABLE_NAME);
        tableNameList.add(PROJECT_CATEGORY_TABLE_NAME);
        tableNameList.add(CATEGORY_TABLE_NAME);
        tableNameList.add(PROJECT_PROPERTY_TABLE_NAME);
        tableNameList.add(ADDITIONAL_PROPERTY_VALUE_TABLE_NAME);
        tableNameList.add(ADDITIONAL_PROPERTY_TABLE_NAME);
        tableNameList.add(PROJECT_TABLE_NAME);

        return tableNameList;
    }

    public static void sortByRelations(List<BaseEntity> baseEntityList) {
        baseEntityList.sort(Comparator.comparingInt(EntityHelper::getRelationOrder));
    }
}
