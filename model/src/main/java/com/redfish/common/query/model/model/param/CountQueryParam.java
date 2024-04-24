package com.redfish.common.query.model.model.param;

import com.redfish.common.query.model.model.condition.QueryCondition;

import java.io.Serializable;

public class CountQueryParam implements Serializable {

    private EntityInfo entityInfo;

    private QueryCondition queryCondition;

    public static CountQueryParam of() {
        return new CountQueryParam();
    }

    public EntityInfo getEntityInfo() {
        return entityInfo;
    }

    public void setEntityInfo(EntityInfo entityInfo) {
        this.entityInfo = entityInfo;
    }

    public CountQueryParam setEntityInfo(String entityCode) {
        this.entityInfo = EntityInfo.of(entityCode);
        return this;
    }

    public QueryCondition getQueryCondition() {
        return queryCondition;
    }

    public CountQueryParam setQueryCondition(QueryCondition queryCondition) {
        this.queryCondition = queryCondition;
        return this;
    }
}
