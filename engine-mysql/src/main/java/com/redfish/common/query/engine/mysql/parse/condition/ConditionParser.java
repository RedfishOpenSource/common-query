package com.redfish.common.query.engine.mysql.parse.condition;

import com.alibaba.cola.extension.ExtensionPointI;
import com.redfish.common.query.engine.mysql.parse.ParseResult;
import com.redfish.common.query.model.model.condition.QueryCondition;

public interface ConditionParser<C extends QueryCondition> extends ExtensionPointI {

    ParseResult parse(C queryCondition);

}
