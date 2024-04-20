package com.redfish.common.query.model.model.param;

import com.redfish.common.query.model.model.condition.QueryCondition;

import java.io.Serializable;

public class CountQueryParam implements Serializable {

    private EntityInfo entityInfo;

    private QueryCondition queryCondition;

}
