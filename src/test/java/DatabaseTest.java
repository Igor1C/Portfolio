import com.igor1c.portfolio.ApplicationStarter;
import com.igor1c.portfolio.entities.*;
import com.igor1c.portfolio.helpers.ApplicationContextProvider;
import com.igor1c.portfolio.helpers.EntityHelper;
import com.igor1c.portfolio.repositories.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationStarter.class)
public class DatabaseTest {

    @Autowired
    private ApplicationContextProvider acp;
    private ApplicationContext context;

    private List<BaseEntity> entityList;

    private final String PROJECT_NAME = "Test project name";



    /* TEST METHODS */

    @Before
    public void init() {
        context = acp.getApplicationContext();
        entityList = new ArrayList<>();
    }

    @After
    public void deleteEntityList() {
        EntityHelper.sortByRelations(entityList);
        entityList.stream().forEach((entity) -> {
            CrudRepository<EntityInterface, Long> crudRepository = EntityHelper.getRepository(entity);
            crudRepository.delete(entity);
        });
    }

    @Test
    public void createProject() {
        ProjectRepository projectRepository = context.getBean(ProjectRepository.class);
        ProjectEntity projectEntity = projectRepository.save(new ProjectEntity(PROJECT_NAME, new byte[0]));
        entityList.add(projectEntity);

        AdditionalPropertyRepository additionalPropertyRepository = context.getBean(AdditionalPropertyRepository.class);
        AdditionalPropertyEntity additionalPropertyEntity = additionalPropertyRepository.save(new AdditionalPropertyEntity("DataBase"));
        entityList.add(additionalPropertyEntity);

        AdditionalPropertyValueRepository additionalPropertyValueRepository = context.getBean(AdditionalPropertyValueRepository.class);
        AdditionalPropertyValueEntity additionalPropertyValueEntity1 = additionalPropertyValueRepository.save(new AdditionalPropertyValueEntity(additionalPropertyEntity, "PostgreSQL"));
        entityList.add(additionalPropertyValueEntity1);
        AdditionalPropertyValueEntity additionalPropertyValueEntity2 = additionalPropertyValueRepository.save(new AdditionalPropertyValueEntity(additionalPropertyEntity, "MySQL"));
        entityList.add(additionalPropertyValueEntity2);

        ProjectPropertyRepository projectPropertyRepository = context.getBean((ProjectPropertyRepository.class));
        ProjectPropertyEntity projectPropertyEntity = projectPropertyRepository.save(new ProjectPropertyEntity(projectEntity, additionalPropertyValueEntity1));
        entityList.add(projectPropertyEntity);
        projectPropertyEntity = projectPropertyRepository.save(new ProjectPropertyEntity(projectEntity, additionalPropertyValueEntity2));
        entityList.add(projectPropertyEntity);

        CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
        CategoryEntity categoryEntity1 = categoryRepository.save(new CategoryEntity("Java"));
        entityList.add(categoryEntity1);
        CategoryEntity categoryEntity2 = categoryRepository.save(new CategoryEntity("Vue.js"));
        entityList.add(categoryEntity2);

        ProjectCategoryRepository projectCategoryRepository = context.getBean(ProjectCategoryRepository.class);
        ProjectCategoryEntity projectCategoryEntity1 = projectCategoryRepository.save(new ProjectCategoryEntity(projectEntity, categoryEntity1));
        entityList.add(projectCategoryEntity1);
        ProjectCategoryEntity projectCategoryEntity2 = projectCategoryRepository.save(new ProjectCategoryEntity(projectEntity, categoryEntity2));
        entityList.add(projectCategoryEntity2);

        LanguageRepository languageRepository = context.getBean(LanguageRepository.class);
        LanguageEntity languageEntity1 = languageRepository.save(new LanguageEntity("EN"));
        entityList.add(languageEntity1);
        LanguageEntity languageEntity2 = languageRepository.save(new LanguageEntity("RU"));
        entityList.add(languageEntity2);

        PurposeRepository purposeRepository = context.getBean(PurposeRepository.class);
        PurposeEntity purposeEntity1 = purposeRepository.save(new PurposeEntity(projectEntity, languageEntity1, "Increase efficiency of the managers.", 1));
        entityList.add(purposeEntity1);
        PurposeEntity purposeEntity2 = purposeRepository.save(new PurposeEntity(projectEntity, languageEntity1, "Make inventorization available.", 2));
        entityList.add(purposeEntity2);

        DescriptionRepository descriptionRepository = context.getBean(DescriptionRepository.class);
        DescriptionEntity descriptionEntity1 = descriptionRepository.save(new DescriptionEntity(projectEntity, languageEntity1, "Short description.", "Description of the project."));
        entityList.add(descriptionEntity1);
        DescriptionEntity descriptionEntity2 = descriptionRepository.save(new DescriptionEntity(projectEntity, languageEntity2, "Краткое описание", "Описание проекта."));
        entityList.add(descriptionEntity2);

        MultimediaRepository multimediaRepository = context.getBean(MultimediaRepository.class);
        MultimediaEntity multimediaEntity1 = multimediaRepository.save(new MultimediaEntity(projectEntity, languageEntity1, null, "http://igor1c.com/test.jpeg"));
        entityList.add(multimediaEntity1);
        MultimediaEntity multimediaEntity2 = multimediaRepository.save(new MultimediaEntity(projectEntity, languageEntity1, "String for the byte[]".getBytes(), null));
        entityList.add(multimediaEntity2);
    }

    @Test
    public void createArticle() {
        LanguageEntity languageDe = new LanguageEntity("de");
        EntityHelper.getRepositoryAndSave(languageDe);
        entityList.add(languageDe);

        LanguageEntity languageFi = new LanguageEntity("fi");
        EntityHelper.getRepositoryAndSave(languageFi);
        entityList.add(languageFi);

        ArticleEntity articleEntity = new ArticleEntity("About", new byte[1]);
        EntityHelper.getRepositoryAndSave(articleEntity);
        entityList.add(articleEntity);

        ArticleContentEntity articleContentEntityDe = new ArticleContentEntity(articleEntity, languageDe, "Test article", "Short description", "Article content");
        EntityHelper.getRepositoryAndSave(articleContentEntityDe);
        entityList.add(articleContentEntityDe);

        ArticleContentEntity articleContentEntityFi = new ArticleContentEntity(articleEntity, languageDe, "Test article", "Anteeksi, mutta en ymmärrä. Puhutteko Te Englantia?", "Yksi, kaksi, kolme, neljä, viisi, kuusi, seitsemän, kahdeksan, yhdensän, kymmenen");
        EntityHelper.getRepositoryAndSave(articleContentEntityFi);
        entityList.add(articleContentEntityFi);
    }
}
