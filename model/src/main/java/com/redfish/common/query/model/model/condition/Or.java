package com.redfish.common.query.model.model.condition;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.LinkedList;
import java.util.List;

@JsonTypeName("Or")
public class Or extends QueryCondition {

    /**
     * 下级节点（每个节点之间是或关系）
     */
    private final List<QueryCondition> children = new LinkedList<>();

    public static Or of(QueryCondition... queryConditions) {
        Or or = new Or();
        for (QueryCondition queryCondition : queryConditions) {
            or.addChild(queryCondition);
        }
        return or;
    }

    public List<QueryCondition> getChildren() {
        return children;
    }

    public Or addChild(QueryCondition queryCondition) {
        this.children.add(queryCondition);
        return this;
    }
}
