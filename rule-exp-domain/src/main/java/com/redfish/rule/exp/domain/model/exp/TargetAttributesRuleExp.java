package com.redfish.rule.exp.domain.model.exp;

import java.util.List;

/**
 * 目标属性规则表达式
 */
public class TargetAttributesRuleExp extends RuleExp{

    private List<String> fieldCodes;

    public List<String> getTargetAttributes() {
        return fieldCodes;
    }

    public void setTargetAttributes(List<String> targetAttributes) {
        this.fieldCodes = targetAttributes;
    }
}
