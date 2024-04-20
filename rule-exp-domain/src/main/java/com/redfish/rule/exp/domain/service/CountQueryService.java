package com.redfish.rule.exp.domain.service;

import com.redfish.rule.exp.domain.model.exp.ResourceRuleExp;
import com.redfish.rule.exp.domain.model.exp.condition.ConditionRuleExp;

public interface CountQueryService {

    /**
     * 查询符合条件的数据数量
     *
     * @param resourceRuleExp
     * @param conditionRuleExp
     * @return
     */
    Long count(ResourceRuleExp resourceRuleExp, ConditionRuleExp conditionRuleExp);

}
