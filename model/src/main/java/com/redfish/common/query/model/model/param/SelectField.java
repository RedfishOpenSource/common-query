package com.redfish.common.query.model.model.param;

import com.redfish.common.query.model.constans.FieldType;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * 目标属性规则表达式
 */
public class SelectField implements Serializable {

    private String entityCode;

    /**
     * 字段编码
     */
    private String fieldCode;

    /**
     * 字段类型
     */
    private FieldType fieldType;

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }
}
