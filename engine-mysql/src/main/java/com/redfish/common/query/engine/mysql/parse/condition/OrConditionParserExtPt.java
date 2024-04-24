package com.redfish.common.query.engine.mysql.parse.condition;

import com.alibaba.cola.extension.Extension;
import com.redfish.common.query.engine.mysql.consts.ConditionParseConsts;
import com.redfish.common.query.engine.mysql.parse.ParseResult;
import com.redfish.common.query.model.model.condition.Or;
import com.redfish.common.query.model.model.condition.QueryCondition;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Extension(bizId = ConditionParseConsts.BIZ_Id,useCase = ConditionParseConsts.USE_CASE,scenario = "Or")
public class OrConditionParserExtPt implements ConditionParserExtPt<Or> {

    @Resource
    private ConditionParseExe conditionParseExe;

    @Override
    public ParseResult parse(Or orQueryCondition) {
        ParseResult parseResult = new ParseResult();
        StringBuilder conditionSqlTemplate = parseResult.getConditionSqlTemplate();

        List<QueryCondition> children = orQueryCondition.getChildren();
        if (CollectionUtils.isEmpty(children)){
            return parseResult;
        }


        conditionSqlTemplate.append(" ( ");


        for(int i=0;i<children.size();i++){
            QueryCondition queryCondition = children.get(i);
            ParseResult parseResultItem = conditionParseExe.parse(queryCondition);
            if (!StringUtils.hasText(parseResultItem.getConditionSqlTemplate().toString())){
                continue;
            }


            // SQL合并
            if (i != 0){
                conditionSqlTemplate.append(" or ");
            }
            conditionSqlTemplate.append(parseResultItem.getConditionSqlTemplate());

            // 合并变量
            parseResult.addParam(parseResultItem.getParams());
        }
        conditionSqlTemplate.append(" ) ");

        return parseResult;
    }


}
