package com.redfish.common.query.engine.mysql.parse.condition;

import com.alibaba.cola.extension.Extension;
import com.redfish.common.query.engine.mysql.consts.ConditionParseConsts;
import com.redfish.common.query.engine.mysql.parse.ParseResult;
import com.redfish.common.query.model.model.condition.And;
import com.redfish.common.query.model.model.condition.QueryCondition;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;


@Component
@Extension(bizId = ConditionParseConsts.BIZ_Id,useCase = ConditionParseConsts.USE_CASE,scenario = "And")
public class AndConditionParser implements ConditionParser<And>{


    @Resource
    private ConditionParseExe conditionParseExe;

    @Override
    public ParseResult parse(And andQueryCondition) {
        ParseResult parseResult = new ParseResult();

        StringBuilder conditionSqlTemplate = parseResult.getConditionSqlTemplate();
        conditionSqlTemplate.append(" ( ");

        List<QueryCondition> children = andQueryCondition.getChildren();
        for(int i=0;i<children.size();i++){
            QueryCondition queryCondition = children.get(i);
            ParseResult parseResultItem = conditionParseExe.parse(queryCondition);

            // SQL合并
            if (i != 0){
                conditionSqlTemplate.append(" and ");
            }
            conditionSqlTemplate.append(parseResultItem.getConditionSqlTemplate());

            // 合并变量
            parseResult.addParam(parseResultItem.getParams());
        }
        conditionSqlTemplate.append(" ) ");

        return parseResult;
    }


}
