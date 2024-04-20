package com.redfish.rule.exp.domain.service;

import com.redfish.rule.exp.domain.dsl.QueryExp;
import com.redfish.rule.exp.domain.model.result.QueryResultItem;

import java.util.List;

public interface PageQueryService {

    /**
     * 分页查询
     *
     * @param queryExp
     * @return
     */
    List<List<QueryResultItem>> page(QueryExp queryExp);

}
