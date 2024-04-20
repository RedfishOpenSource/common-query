package com.redfish.rule.exp.domain.model.exp;

import com.redfish.rule.exp.domain.constans.SortConditionEnum;

/**
 * 排序规则表达式
 */
public class SortRuleExp extends RuleExp{

    /**
     * 目标资源属性code
     */
    private String attributeCode;

    /**
     * sort条件
     */
    private SortConditionEnum sortConditionEnum;

    /**
     * 排序优先级。
     */
    private Integer sortNum;

}
