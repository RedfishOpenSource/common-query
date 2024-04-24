package com.redfish.common.query.model.service;


import com.redfish.common.query.model.model.param.CountQueryParam;

public interface CountQueryService {

    /**
     * 查询符合条件的数据数量
     *
     * @param countQueryParam
     * @return
     */
    Integer count(CountQueryParam countQueryParam);

}
