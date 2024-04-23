package com.redfish.common.query.model.model.param;

import java.io.Serializable;

/**
 * 资源规则表达式
 */
public class EntityInfo implements Serializable {

    // 实体编码
    private String entityCode;

    public String getEntityCode() {
        return entityCode;
    }

    private EntityInfo() {
    }

    public static EntityInfo of(String entityCode) {
        EntityInfo entityInfo = new EntityInfo();
        entityInfo.setEntityCode(entityCode);
        return entityInfo;
    }

    public EntityInfo setEntityCode(String entityCode) {
        this.entityCode = entityCode;
        return this;
    }
}