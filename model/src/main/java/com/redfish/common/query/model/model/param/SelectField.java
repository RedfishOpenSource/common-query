package com.redfish.common.query.model.model.param;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * 目标属性规则表达式
 */
public class SelectField implements Serializable {

    private final List<String> fieldCodes = new LinkedList<>();

    public List<String> getTargetAttributes() {
        return fieldCodes;
    }

    public void addFieldCode(String fieldCode) {
        this.fieldCodes.add(fieldCode);
    }

}
