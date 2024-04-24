package com.redfish.common.query.model.model.param;

import com.redfish.common.query.model.model.condition.QueryCondition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QueryOneParam implements Serializable {

    private EntityInfo entityInfo;

    private QueryCondition queryCondition;

    private List<SelectField> selectFields  = new ArrayList<>();

    public static QueryOneParam of() {
        return new QueryOneParam();
    }


    public EntityInfo getEntityInfo() {
        return entityInfo;
    }

    public QueryOneParam setEntityInfo(EntityInfo entityInfo) {
        this.entityInfo = entityInfo;
        return this;
    }

    public QueryOneParam setEntityInfo(String entityCode) {
        this.entityInfo = EntityInfo.of(entityCode);
        return this;
    }

    public QueryCondition getQueryCondition() {
        return queryCondition;
    }

    public QueryOneParam setQueryCondition(QueryCondition queryCondition) {
        this.queryCondition = queryCondition;
        return this;
    }

    public List<SelectField> getSelectFields() {
        return selectFields;
    }

    public QueryOneParam setSelectFields(List<SelectField> selectFields) {
        this.selectFields = selectFields;
        return this;
    }

    public QueryOneParam setSelectFields(String... selectFieldCodes) {
        if (null != selectFieldCodes){
            for (String selectFieldCode : selectFieldCodes) {
                SelectField selectField = SelectField.of(selectFieldCode)
                        .setEntityCode(this.entityInfo.getEntityCode());
                this.selectFields.add(selectField);
            }
        }
        return this;
    }
}
