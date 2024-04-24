package com.redfish.common.query.model.model.param;

import com.redfish.common.query.model.common.CommonQueryException;
import com.redfish.common.query.model.common.ErrorCodeEnum;

import java.io.Serializable;


/**
 * 分页查询规则表达式，在原有查询规则基础上，增加了分页。
 */
public class PageInfo implements Serializable {


    private Integer pageNum = 1;


    private Integer pageSize = 20;

    public static PageInfo of(Integer pageNum, Integer pageSize) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        return pageInfo;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if (pageNum == null && pageNum<=0){
            throw new CommonQueryException(ErrorCodeEnum.PARAM_ERROR,"pageNum must be greater than zero.");
        }
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null && pageSize<=0){
            throw new CommonQueryException(ErrorCodeEnum.PARAM_ERROR,"pageSize must be greater than zero.");
        }
        this.pageSize = pageSize;
    }

    public Integer getOffset(){
        return (pageNum-1)*pageSize;
    }

}