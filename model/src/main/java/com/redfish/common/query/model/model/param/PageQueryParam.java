package com.redfish.common.query.model.model.param;

import com.redfish.common.query.model.model.condition.QueryCondition;

import java.io.Serializable;
import java.util.List;

public class PageQueryParam implements Serializable {

    private EntityInfo entityInfo;

    private QueryCondition queryCondition;

    private List<SelectField> selectFields;

    private List<SortInfo> sortInfos;

    private PageInfo pageInfo;

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

    public List<SelectField> getSelectFields() {
        return selectFields;
    }

    public void setSelectFields(List<SelectField> selectFields) {
        this.selectFields = selectFields;
    }

    public List<SortInfo> getSortInfos() {
        return sortInfos;
    }

    public void setSortInfos(List<SortInfo> sortInfos) {
        this.sortInfos = sortInfos;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
