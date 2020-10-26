package com.igor1c.portfolio.controllers;

import com.google.gson.Gson;
import com.igor1c.portfolio.dto.CategoryDto;
import com.igor1c.portfolio.dto.MultimediaDto;
import com.igor1c.portfolio.dto.ProjectDto;
import com.igor1c.portfolio.dto.helpers.FilterOptions;
import com.igor1c.portfolio.dto.helpers.ProjectAdditionalPropertyDto;
import com.igor1c.portfolio.entities.LanguageEntity;
import com.igor1c.portfolio.entities.ProjectEntity;
import com.igor1c.portfolio.entities.helpers.ProjectAdditionalProperty;
import com.igor1c.portfolio.helpers.ApplicationContextProvider;
import com.igor1c.portfolio.mappers.CategoryMapper;
import com.igor1c.portfolio.mappers.MultimediaMapper;
import com.igor1c.portfolio.mappers.ProjectMapper;
import com.igor1c.portfolio.mappers.helpers.ProjectAdditionalPropertyMapper;
import com.igor1c.portfolio.repositories.CategoryRepository;
import com.igor1c.portfolio.repositories.LanguageRepository;
import com.igor1c.portfolio.repositories.ProjectRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("project")
public class ProjectController {

    @Autowired
    private ApplicationContextProvider acp;
    private ApplicationContext context;

    private final ProjectRepository projectRepository;
    private final LanguageRepository languageRepository;
    private final CategoryRepository categoryRepository;



    /* CONSTRUCTORS */

    public ProjectController() {
        context = acp.getApplicationContext();
        projectRepository = context.getBean(ProjectRepository.class);
        languageRepository = context.getBean(LanguageRepository.class);
        categoryRepository = context.getBean(CategoryRepository.class);
    }



    /* CRUD METHODS OF THE PROJECT */

    @PostMapping
    public ProjectEntity create(@RequestBody ProjectEntity projectEntity) {
        return projectRepository.save(projectEntity);
    }

    @GetMapping("/getAll")
    @Transactional
    public List<ProjectDto> getAll(@RequestParam String language) {
        List<ProjectDto> projectDtoList = new ArrayList<>();

        getAllAndFilterByLanguage(language).forEach(projectEntity ->
                projectDtoList.add(ProjectMapper.INSTANCE.fromEntity(projectEntity))
        );
        return projectDtoList;
    }

    @PostMapping("/getWithFilter")
    @Transactional
    public List<ProjectDto> getWithFilter(@RequestParam("language") String language, @RequestParam("filterOptions") String filterOptionsJson) {
        Gson gson = new Gson();
        FilterOptions filterOptions = gson.fromJson(filterOptionsJson, FilterOptions.class);

        List<ProjectDto> projectDtoList = new ArrayList<>();
        List<ProjectEntity> projectEntityList = getAllAndFilterByLanguage(language);
        ProjectEntity.filterByFilterOptions(projectEntityList, filterOptions).forEach(e ->
                projectDtoList.add(ProjectMapper.INSTANCE.fromEntity(e)));

        return projectDtoList;
    }

    private List<ProjectEntity> getAllAndFilterByLanguage(String language) {
        LanguageEntity languageEntity = languageRepository.findByName(language);
        List<ProjectEntity> projectEntityList = projectRepository.findAll();
        projectEntityList.forEach((projectEntity) -> {
            projectEntity.filterByLanguage(languageEntity);
            projectEntity.limitMultimediaData(0);
            projectEntity.lazyInit();
        });

        return projectEntityList;
    }

    @GetMapping("")
    @Transactional
    public ProjectDto get(@RequestParam Long id, @RequestParam String language) {
        LanguageEntity languageEntity = languageRepository.findByName(language);

        ProjectEntity projectEntity = projectRepository.findById(id).get();
        projectEntity.filterByLanguage(languageEntity);
        projectEntity.limitMultimediaData(0);
        projectEntity.lazyInit();

        return ProjectMapper.INSTANCE.fromEntity(projectEntity);
    }

    @GetMapping("/getByName")
    @Transactional
    public ProjectDto getByName(@RequestParam String name, @RequestParam String language) {
        LanguageEntity languageEntity = languageRepository.findByName(language);
        ProjectEntity projectEntity = getProjectEntityByName(name, languageEntity, 0);
        return ProjectMapper.INSTANCE.fromEntity(projectEntity);
    }

    @GetMapping("/getMultimedia")
    @Transactional
    public List<MultimediaDto> getMultimedia(@RequestParam Long id, @RequestParam String language) {
        LanguageEntity languageEntity = languageRepository.findByName(language);

        ProjectEntity projectEntity = projectRepository.findById(id).get();
        projectEntity.filterByLanguage(languageEntity);
        projectEntity.lazyInit();

        List<MultimediaDto> multimediaDtoList = new ArrayList<>();
        projectEntity.getMultimediaList().forEach(multimediaEntity ->
                multimediaDtoList.add(MultimediaMapper.INSTANCE.fromEntity(multimediaEntity)));

        return multimediaDtoList;
    }

    @GetMapping("/getMultimediaByName")
    @Transactional
    public List<MultimediaDto> getMultimediaByName(@RequestParam String name, @RequestParam String language) {
        LanguageEntity languageEntity = languageRepository.findByName(language);
        ProjectEntity projectEntity = getProjectEntityByName(name, languageEntity, -1);

        List<MultimediaDto> multimediaDtoList = new ArrayList<>();
        projectEntity.getMultimediaList().forEach(multimediaEntity ->
                multimediaDtoList.add(MultimediaMapper.INSTANCE.fromEntity(multimediaEntity)));

        return multimediaDtoList;
    }

    @PutMapping("{id}")
    public ProjectEntity update(@PathVariable("id") ProjectEntity projectEntityFromDb, @RequestBody ProjectEntity projectEntity) {
        BeanUtils.copyProperties(projectEntity, projectEntityFromDb, "id");
        return projectRepository.save(projectEntityFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") ProjectEntity projectEntity) {
        projectRepository.delete(projectEntity);
    }



    /* CRUD METHODS OF THE FILTER */

    @GetMapping("/getFilterOptions")
    @Transactional
    public FilterOptions getFilterOptions() {
        List<ProjectAdditionalPropertyDto> projectAdditionalPropertyDtoList = new ArrayList<>();

        ProjectAdditionalProperty.getAllProjectAdditionalPropertyList().stream().forEach(projectAdditionalProperty -> {
            projectAdditionalProperty.getAdditionalPropertyEntity().lazyInit();
            projectAdditionalPropertyDtoList.add(ProjectAdditionalPropertyMapper.INSTANCE.fromEntity(projectAdditionalProperty));
        });

        List<CategoryDto> categoryDtoList = new ArrayList<>();
        categoryRepository.findAll().stream().forEach(categoryEntity ->
                categoryDtoList.add(CategoryMapper.INSTANCE.fromEntity(categoryEntity)));

        return new FilterOptions(projectAdditionalPropertyDtoList, categoryDtoList);
    }



    /* FUNCTIONAL */
    private ProjectEntity getProjectEntityByName(String name, LanguageEntity languageEntity, int limitMultimedia) {
        ProjectEntity projectEntity;

        List<ProjectEntity> projectEntityList = projectRepository.findByName(name);
        if (projectEntityList.size() > 0) {
            projectEntity = projectEntityList.get(0);
            projectEntity.filterByLanguage(languageEntity);
            if (limitMultimedia >= 0) {
                projectEntity.limitMultimediaData(limitMultimedia);
            }
            projectEntity.lazyInit();
        } else {
            projectEntity = new ProjectEntity();
        }

        return projectEntity;
    }
}
