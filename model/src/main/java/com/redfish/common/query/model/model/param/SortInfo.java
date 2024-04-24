package com.redfish.common.query.model.model.param;



import com.redfish.common.query.model.constans.SortConditionEnum;

import java.io.Serializable;

/**
 * 排序规则表达式
 */
public class SortInfo implements Serializable {

    /**
     * entityCode
     */
    private String entityCode;

    /**
     * 目标资源属性code
     */
    private String fieldCode;

    /**
     * sort条件
     */
    private SortConditionEnum sortConditionEnum;

    /**
     * 排序优先级。
     */
    private Integer sortNum = 0;

    public static SortInfo of(String fieldCode, SortConditionEnum sortConditionEnum) {
        SortInfo sortInfo = new SortInfo();
        sortInfo.setFieldCode(fieldCode);
        sortInfo.setSortConditionEnum(sortConditionEnum);
        return sortInfo;
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    public SortConditionEnum getSortConditionEnum() {
        return sortConditionEnum;
    }

    public void setSortConditionEnum(SortConditionEnum sortConditionEnum) {
        this.sortConditionEnum = sortConditionEnum;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }
}
