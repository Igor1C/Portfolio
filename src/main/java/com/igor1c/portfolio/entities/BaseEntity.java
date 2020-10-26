package com.igor1c.portfolio.entities;

public abstract class BaseEntity implements EntityInterface {

    private String entityName;

    protected BaseEntity(String entityName) {
        setEntityName(entityName);
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    @Override
    public void lazyInit() {}
}
