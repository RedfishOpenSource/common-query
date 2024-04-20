package com.redfish.rule.exp.domain.model.exp.condition;



public class NotRuleExp extends ConditionRuleExp {

    /**
     * 需要被否定的表达式
     */
    private ConditionRuleExp subExp;


    public ConditionRuleExp getSubExp() {
        return subExp;
    }

    public void setSubExp(ConditionRuleExp subExp) {
        this.subExp = subExp;
    }
}
