package com.redfish.common.query.engine.mysql.entity;

import com.redfish.common.query.model.constans.FieldType;

import java.io.Serializable;

public class FieldColumnInfo implements Serializable {

    /**
     * 实体编码
     */
    private String entityCode;

    /**
     * 字段编码
     */
    private String fieldCode;

    /**
     * 物理字段的数据表列名称
     */
    private String columnName;


    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }


    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}
