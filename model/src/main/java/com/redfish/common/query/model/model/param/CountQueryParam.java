package com.redfish.common.query.model.model.param;

import com.redfish.common.query.model.model.condition.QueryCondition;

import java.io.Serializable;

public class CountQueryParam implements Serializable {

    private EntityInfo entityInfo;

    private QueryCondition queryCondition;

    public EntityInfo getEntityInfo() {
        return entityInfo;
    }

    public void setEntityInfo(EntityInfo entityInfo) {
        this.entityInfo = entityInfo;
    }

    public QueryCondition getQueryCondition() {
        return queryCondition;
    }

    public void setQueryCondition(QueryCondition queryCondition) {
        this.queryCondition = queryCondition;
    }
}
