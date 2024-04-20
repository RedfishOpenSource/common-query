package com.redfish.rule.exp.domain.model.exp.condition;

/**
 * 逻辑常量，真或假，表达全匹配或全不匹配
 */
public class ConstExpRule extends ConditionRuleExp {

    private boolean value;


    public boolean getValue() {
        // 默认生成isValue，手动生成getValue
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
