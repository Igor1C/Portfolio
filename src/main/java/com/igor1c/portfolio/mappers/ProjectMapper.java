package com.igor1c.portfolio.mappers;

import com.igor1c.portfolio.dto.AdditionalPropertyDto;
import com.igor1c.portfolio.dto.AdditionalPropertyValueDto;
import com.igor1c.portfolio.dto.ProjectDto;
import com.igor1c.portfolio.entities.AdditionalPropertyEntity;
import com.igor1c.portfolio.entities.AdditionalPropertyValueEntity;
import com.igor1c.portfolio.entities.ProjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    ProjectDto fromEntity(ProjectEntity projectEntity);

    default Map<String, List<AdditionalPropertyValueDto>> map(Map<AdditionalPropertyEntity, List<AdditionalPropertyValueEntity>> inputMap) {
        Map<String, List<AdditionalPropertyValueDto>> map = new HashMap<>();

        inputMap.keySet().stream().forEach(key -> {
            AdditionalPropertyDto additionalPropertyDto = AdditionalPropertyMapper.INSTANCE.fromEntity(key);
            List<AdditionalPropertyValueDto> additionalPropertyDtoList = new ArrayList();

            inputMap.get(key).stream().forEach(e -> additionalPropertyDtoList.add(AdditionalPropertyValueMapper.INSTANCE.fromEntity(e)));
            map.put(additionalPropertyDto.getName(), additionalPropertyDtoList);
        });

        return map;
    }
}
