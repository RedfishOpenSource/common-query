package com.redfish.common.query.model.model.param;



import com.redfish.common.query.model.constans.SortConditionEnum;

import java.io.Serializable;

/**
 * 排序规则表达式
 */
public class SortInfo implements Serializable {

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
    private Integer sortNum;

}
