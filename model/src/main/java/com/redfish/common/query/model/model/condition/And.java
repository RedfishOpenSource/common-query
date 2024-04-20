package com.redfish.common.query.model.model.condition;

import java.util.LinkedList;
import java.util.List;

public class And extends QueryCondition {

    /**
     * 下级节点（每个节点之间是且关系）
     */
    private final List<QueryCondition> children = new LinkedList<>();


    public List<QueryCondition> getChildren() {
        return children;
    }


    public And addChild(QueryCondition queryCondition) {
        this.children.add(queryCondition);
        return this;
    }


}
