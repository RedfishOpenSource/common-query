package com.redfish.common.query.model.model.condition;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import javafx.scene.shape.Circle;

import java.io.Serializable;

/**
 * 条件规则表达式，用于描述and or，=，！=等各种条件规则
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public abstract class QueryCondition implements Serializable {


    private String type;

}
