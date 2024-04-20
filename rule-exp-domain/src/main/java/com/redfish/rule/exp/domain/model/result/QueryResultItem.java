package com.redfish.rule.exp.domain.model.result;

import java.io.Serializable;

public class QueryResultItem implements Serializable {

    /**
     * 字段
     */
    private String attribute;

    /**
     * 值
     */
    private Object value;

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
