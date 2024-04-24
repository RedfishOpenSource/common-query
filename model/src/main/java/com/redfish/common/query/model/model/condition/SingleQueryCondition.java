package com.redfish.common.query.model.model.condition;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.redfish.common.query.model.constans.ConditionTypeEnum;

import java.util.List;

/**
 * 条件规则表达式，如 eq,like等
 */
@JsonTypeName("Single")
public class SingleQueryCondition extends QueryCondition {




    /**
     * 参与条件的属性。
     * 参与条件过滤的一定是物理字段
     */
    private String fieldCode;


    /**
     * 条件运算符
     */
    private ConditionTypeEnum conditionType;

    /**
     * 单值情况，如equals，like等
     */
    private Object value;

    public static SingleQueryCondition of(String fieldCode){
        SingleQueryCondition singleQueryCondition = new SingleQueryCondition();
        singleQueryCondition.setFieldCode(fieldCode);
        return singleQueryCondition;
    }


    public String getFieldCode() {
        return fieldCode;
    }

    public SingleQueryCondition setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
        return this;
    }

    public ConditionTypeEnum getConditionType() {
        return conditionType;
    }

    public SingleQueryCondition setConditionType(ConditionTypeEnum conditionType) {
        this.conditionType = conditionType;
        return this;
    }

    public Object getValue() {
        return value;
    }

    public SingleQueryCondition setValue(Object value) {
        this.value = value;
        return this;
    }


}
