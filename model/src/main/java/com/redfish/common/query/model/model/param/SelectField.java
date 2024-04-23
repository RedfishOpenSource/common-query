package com.redfish.common.query.model.model.param;

import com.redfish.common.query.model.constans.FieldType;

import java.io.Serializable;

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

    private SelectField() {
    }

    public static SelectField of(String fieldCode) {
        SelectField selectField =  new SelectField();
        selectField.setFieldType(FieldType.PHYSICAL);
        selectField.setFieldCode(fieldCode);
        return selectField;
    }

    public SelectField setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
        return this;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public SelectField setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
        return this;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public SelectField setEntityCode(String entityCode) {
        this.entityCode = entityCode;
        return this;
    }
}
