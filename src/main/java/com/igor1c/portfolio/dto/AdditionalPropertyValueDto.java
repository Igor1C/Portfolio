package com.igor1c.portfolio.dto;

import com.igor1c.portfolio.dto.helpers.Selectable;

public class AdditionalPropertyValueDto implements Selectable {
    private Long id;
    private AdditionalPropertyDto additionalProperty;
    private String name;
    private boolean selected;



    /* GETTERS & SETTERS */

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AdditionalPropertyDto getAdditionalProperty() {
        return additionalProperty;
    }

    public void setAdditionalProperty(AdditionalPropertyDto additionalProperty) {
        this.additionalProperty = additionalProperty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    /* GETTERS & SETTERS OF NON-TABLE FIELDS */

    @Override
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
