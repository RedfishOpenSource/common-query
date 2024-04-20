package com.redfish.common.query.model.service;


import com.redfish.common.query.model.model.param.PageQueryParam;
import com.redfish.common.query.model.model.result.QueryResultRowData;

public interface PageQueryService {

    /**
     * 分页查询
     *
     * @param pageQueryParam
     * @return
     */
    QueryResultRowData page(PageQueryParam pageQueryParam);

}
