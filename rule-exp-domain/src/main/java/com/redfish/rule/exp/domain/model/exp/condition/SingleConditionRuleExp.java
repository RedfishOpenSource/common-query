package com.redfish.rule.exp.domain.model.exp.condition;

import java.util.List;

/**
 * 条件规则表达式，如 eq,like等
 */
public class SingleConditionRuleExp extends ConditionRuleExp{

    /**
     * 参与条件的属性
     */
    private String field;


    /**
     * 条件运算符
     */
    private String operator;

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
