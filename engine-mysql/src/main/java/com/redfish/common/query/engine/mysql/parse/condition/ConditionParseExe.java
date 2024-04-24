package com.redfish.common.query.engine.mysql.parse.condition;

import com.alibaba.cola.extension.BizScenario;
import com.alibaba.cola.extension.ExtensionExecutor;
import com.redfish.common.query.engine.mysql.parse.ParseResult;
import com.redfish.common.query.engine.mysql.consts.ConditionParseConsts;
import com.redfish.common.query.model.model.condition.QueryCondition;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ConditionParseExe {

    @Resource
    private ExtensionExecutor extensionExecutor;


    public ParseResult parse(QueryCondition queryCondition) {
        if (queryCondition == null){
            return new ParseResult();
        }

        BizScenario bizScenario = BizScenario.valueOf(ConditionParseConsts.BIZ_Id, ConditionParseConsts.USE_CASE, queryCondition.getClass().getSimpleName());
        return extensionExecutor.execute(ConditionParserExtPt.class, bizScenario,
                ex -> ex.parse(queryCondition));
    }

}
