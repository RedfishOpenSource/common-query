package com.redfish.common.query.model.model.param;

import com.redfish.common.query.model.model.condition.QueryCondition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageQueryParam implements Serializable {

    private EntityInfo entityInfo;

    private QueryCondition queryCondition;

    private List<SelectField> selectFields = new ArrayList<>();

    private List<SortInfo> sortInfos;

    private PageInfo pageInfo;

    public EntityInfo getEntityInfo() {
        return entityInfo;
    }

    public static PageQueryParam of() {
        return new PageQueryParam();
    }


    public PageQueryParam setEntityInfo(String entityCode) {
        this.entityInfo = EntityInfo.of(entityCode);
        return this;
    }

    public PageQueryParam setEntityInfo(EntityInfo entityInfo) {
        this.entityInfo = entityInfo;
        return this;
    }

    public QueryCondition getQueryCondition() {
        return queryCondition;
    }

    public PageQueryParam queryCondition(QueryCondition queryCondition) {
        this.queryCondition = queryCondition;
        return this;
    }

    public List<SelectField> getSelectFields() {
        return selectFields;
    }

    public PageQueryParam selectFields(List<SelectField> selectFields) {
        this.selectFields = selectFields;
        return this;
    }

    public PageQueryParam selectFields(String... selectFieldCodes) {
        if (null != selectFieldCodes){
            for (String selectFieldCode : selectFieldCodes) {
                SelectField selectField = SelectField.of(selectFieldCode)
                                .setEntityCode(this.entityInfo.getEntityCode());
                this.selectFields.add(selectField);
            }
        }
        return this;
    }

    public PageQueryParam selectFields(SelectField... selectFields) {
        if (null != selectFields){
            for (SelectField selectField : selectFields) {
                selectField.setEntityCode(this.entityInfo.getEntityCode());
                this.selectFields.add(selectField);
            }
        }
        return this;
    }

    public List<SortInfo> getSortInfos() {
        return sortInfos;
    }

    public PageQueryParam sortInfos(List<SortInfo> sortInfos) {
        this.sortInfos = sortInfos;
        return this;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public PageQueryParam pageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
        return this;
    }
}
