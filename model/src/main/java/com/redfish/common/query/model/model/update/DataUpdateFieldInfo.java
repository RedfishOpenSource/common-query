package com.redfish.common.query.model.model.update;

import java.io.Serializable;

public class DataUpdateFieldInfo implements Serializable {

    private String fieldCode;

    private Object value;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
