package com.redfish.common.query.model.model.condition;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import javafx.scene.shape.Circle;

import java.io.Serializable;

/**
 * 条件规则表达式，用于描述and or，=，！=等各种条件规则
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public abstract class QueryCondition implements Serializable {

    public QueryCondition() {
        JsonTypeName jsonTypeName = this.getClass().getAnnotation(JsonTypeName.class);
        this.type = jsonTypeName.value();
    }

    private String type;

    private String entityCode;

    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
