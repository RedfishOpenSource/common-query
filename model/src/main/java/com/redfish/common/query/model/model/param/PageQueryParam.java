package com.redfish.common.query.model.model.param;

import com.redfish.common.query.model.model.condition.QueryCondition;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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

    public PageQueryParam setQueryCondition(QueryCondition queryCondition) {
        this.queryCondition = queryCondition;
        return this;
    }

    public List<SelectField> getSelectFields() {
        return selectFields;
    }

    public PageQueryParam setSelectFields(List<SelectField> selectFields) {
        this.selectFields = selectFields;
        return this;
    }

    public PageQueryParam setSelectFields(String... selectFieldCodes) {
        if (null != selectFieldCodes){
            for (String selectFieldCode : selectFieldCodes) {
                SelectField selectField = SelectField.of(selectFieldCode)
                                .setEntityCode(this.entityInfo.getEntityCode());
                this.selectFields.add(selectField);
            }
        }
        return this;
    }

    public PageQueryParam setSelectFields(SelectField... selectFields) {
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

    public PageQueryParam setSortInfos(SortInfo... sortInfos) {
        this.setSortInfos(Arrays.asList(sortInfos));
        return this;
    }

    public PageQueryParam setSortInfos(List<SortInfo> sortInfos) {
        sortInfos.forEach(sortInfo -> sortInfo.setEntityCode(this.entityInfo.getEntityCode()));
        this.sortInfos = sortInfos;
        return this;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public PageQueryParam setPageInfo(Integer pageNum, Integer pageSize) {
        this.pageInfo = PageInfo.of(pageNum, pageSize);
        return this;
    }

    public PageQueryParam setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
        return this;
    }
}
