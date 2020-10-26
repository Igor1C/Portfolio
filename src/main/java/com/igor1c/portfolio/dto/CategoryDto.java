package com.igor1c.portfolio.dto;

import com.igor1c.portfolio.dto.helpers.Selectable;

public class CategoryDto implements Selectable {
    private Long id;
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
