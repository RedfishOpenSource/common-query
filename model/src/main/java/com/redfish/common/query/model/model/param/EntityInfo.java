package com.redfish.common.query.model.model.param;

import java.io.Serializable;

/**
 * 资源规则表达式
 */
public class EntityInfo implements Serializable {

    // 实体编码
    private String entityCode;

    public String getResource() {
        return entityCode;
    }

    public void setResource(String resource) {
        this.entityCode = resource;
    }
}