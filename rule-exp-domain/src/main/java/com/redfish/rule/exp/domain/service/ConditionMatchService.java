package com.redfish.rule.exp.domain.service;

import com.redfish.rule.exp.domain.model.exp.ResourceRuleExp;
import com.redfish.rule.exp.domain.model.exp.condition.ConditionRuleExp;

public interface ConditionMatchService {

    /**
     * 判断目标资源是否被指定条件规则命中
     *
     * @param targetResourceUniqId
     * @param resourceRuleExp
     * @param conditionRuleExp
     * @return
     */
    Boolean match(String targetResourceUniqId, ResourceRuleExp resourceRuleExp, ConditionRuleExp conditionRuleExp);


}

