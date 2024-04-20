package com.redfish.common.query.model.model.result;

import java.io.Serializable;

public class QueryResultFieldData implements Serializable {

    private String fieldCode;

    private Object value;

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
