package com.redfish.rule.exp.domain.model.exp.condition;

import java.util.LinkedList;
import java.util.List;

public class AndRuleExp extends ConditionRuleExp {

    /**
     * 下级节点（每个节点之间是且关系）
     */
    private List<ConditionRuleExp> children = new LinkedList<>();


    public List<ConditionRuleExp> getChildren() {
        return children;
    }

    public void setChildren(List<ConditionRuleExp> children) {
        this.children = children;
    }
}
