package com.redfish.rule.exp.domain.service;

import com.redfish.rule.exp.domain.dsl.QueryExp;
import com.redfish.rule.exp.domain.model.result.QueryResultItem;

import java.util.List;

public interface QueryOneService {

    /**
     * 获取符合条件规则的唯一目标资源。
     * 如果目标资源不存在，则返回null;
     * 如果存在，返回唯一符合条件的目标资源。
     * 如果符合条件的目标资源不止一个，则报错。
     *
     * @param queryExp
     * @return
     */
    List<QueryResultItem> getOne(QueryExp queryExp);

}
