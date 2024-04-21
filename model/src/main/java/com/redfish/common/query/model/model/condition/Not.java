package com.redfish.common.query.model.model.condition;


import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Not")
public class Not extends QueryCondition {

    /**
     * 需要被否定的表达式
     */
    private final QueryCondition subQueryCondition;

    public Not(QueryCondition subQueryCondition) {
        this.subQueryCondition = subQueryCondition;
    }

    public static Not not(QueryCondition subQueryCondition) {
        return new Not(subQueryCondition);
    }

    public QueryCondition getSubCondition() {
        return subQueryCondition;
    }

}
