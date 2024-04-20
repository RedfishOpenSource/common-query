package com.redfish.rule.exp.domain.dsl.base;

import com.redfish.rule.exp.domain.model.exp.TargetAttributesRuleExp;
import com.redfish.rule.exp.domain.model.exp.condition.ConditionRuleExp;


public interface From {

    Select select(TargetAttributesRuleExp targetAttributesRuleExp);

    Where where(ConditionRuleExp conditionRuleExp);

}
