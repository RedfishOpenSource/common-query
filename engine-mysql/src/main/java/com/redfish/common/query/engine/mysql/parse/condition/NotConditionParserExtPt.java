package com.redfish.common.query.engine.mysql.parse.condition;

import com.alibaba.cola.extension.Extension;
import com.redfish.common.query.engine.mysql.consts.ConditionParseConsts;
import com.redfish.common.query.engine.mysql.parse.ParseResult;
import com.redfish.common.query.model.model.condition.Not;
import com.redfish.common.query.model.model.condition.QueryCondition;

import javax.annotation.Resource;


@Extension(bizId = ConditionParseConsts.BIZ_Id,useCase = ConditionParseConsts.USE_CASE,scenario = "Not")
public class NotConditionParserExtPt implements ConditionParserExtPt<Not> {

    @Resource
    private ConditionParseExe conditionParseExe;

    @Override
    public ParseResult parse(Not queryCondition) {
        ParseResult parseResult = new ParseResult();

        QueryCondition queryConditionItem = queryCondition.getSubCondition();
        ParseResult parseResultItem = conditionParseExe.parse(queryConditionItem);

        parseResult.addParam(parseResultItem.getParams());

        StringBuilder conditionSqlTemplate = parseResult.getConditionSqlTemplate();
        conditionSqlTemplate.append(" !( ");
        conditionSqlTemplate.append(parseResultItem.getConditionSqlTemplate());
        conditionSqlTemplate.append(" )");


        return parseResult;
    }


}
