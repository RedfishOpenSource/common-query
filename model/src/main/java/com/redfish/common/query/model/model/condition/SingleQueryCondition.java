package com.redfish.common.query.model.model.condition;

import com.redfish.common.query.model.constans.ConditionTypeEnum;

import java.util.List;

/**
 * 条件规则表达式，如 eq,like等
 */
public class SingleQueryCondition extends QueryCondition {

    /**
     * 参与条件的属性
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

    /**
     * 参与条件运算的value值
     * 多值情況，如in，not in
     */
    private List<Object> values;

}
