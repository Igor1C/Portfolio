package com.igor1c.portfolio.dto.helpers;

import com.igor1c.portfolio.dto.CategoryDto;

import java.util.ArrayList;
import java.util.List;

public class FilterOptions {
    List<ProjectAdditionalPropertyDto> properties = new ArrayList<>();
    List<CategoryDto> categories = new ArrayList<>();



    /* CONSTRUCTORS */

    public FilterOptions() {};

    public FilterOptions(List<ProjectAdditionalPropertyDto> properties, List<CategoryDto> categories) {
        this.properties = properties;
        this.categories = categories;
    }



    /* GETTERS & SETTERS */

    public List<ProjectAdditionalPropertyDto> getProperties() {
        return properties;
    }

    public void setProperties(List<ProjectAdditionalPropertyDto> properties) {
        this.properties = properties;
    }

    public List<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDto> categories) {
        this.categories = categories;
    }
}
