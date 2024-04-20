package com.redfish.rule.exp.domain.model.exp;

import com.redfish.rule.exp.domain.common.ErrorCodeEnum;
import com.redfish.rule.exp.domain.common.ExpException;

/**
 * 分页查询规则表达式，在原有查询规则基础上，增加了分页。
 */
public class PageRuleExp extends RuleExp {


    private Integer pageNum;


    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if (pageNum == null && pageNum<=0){
            throw new ExpException(ErrorCodeEnum.PARAM_ERROR,"pageNum must be greater than zero.");
        }
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null && pageSize<=0){
            throw new ExpException(ErrorCodeEnum.PARAM_ERROR,"pageSize must be greater than zero.");
        }
        this.pageSize = pageSize;
    }
}