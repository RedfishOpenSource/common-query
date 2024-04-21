package com.redfish.common.query.engine.mysql.parse.condition;

import com.alibaba.cola.extension.Extension;
import com.redfish.common.query.engine.mysql.consts.MysqlConditionSymbolEnum;
import com.redfish.common.query.engine.mysql.entity.FieldColumnInfo;
import com.redfish.common.query.engine.mysql.parse.ParseResult;
import com.redfish.common.query.engine.mysql.service.EntityDaoInfo;
import com.redfish.common.query.model.constans.ConditionTypeEnum;
import com.redfish.common.query.model.model.condition.SingleQueryCondition;
import org.springframework.stereotype.Component;
import com.redfish.common.query.engine.mysql.consts.ConditionParseConsts;

import javax.annotation.Resource;

@Component
@Extension(bizId = ConditionParseConsts.BIZ_Id,useCase = ConditionParseConsts.USE_CASE,scenario = "SingleQueryCondition")
public class SingleQueryConditionParser implements ConditionParser<SingleQueryCondition>{

    @Resource
    private EntityDaoInfo entityDaoInfo;

    @Override
    public ParseResult parse(SingleQueryCondition singleQueryCondition) {
        ParseResult parseResult = new ParseResult();

        StringBuilder conditionSqlTemplate = parseResult.getConditionSqlTemplate();

        String fieldCode = singleQueryCondition.getFieldCode();
        FieldColumnInfo fieldColumnInfo = entityDaoInfo.getFieldInfo(singleQueryCondition.getEntityCode(),fieldCode);
        String columnName = fieldColumnInfo.getColumnName();

        // 收集参数
        ConditionTypeEnum conditionTypeEnum = singleQueryCondition.getConditionType();
        Object value = singleQueryCondition.getValue();
        parseResult.addParam(value);

        // 构建SQL
        MysqlConditionSymbolEnum mysqlConditionSymbolEnum = MysqlConditionSymbolEnum.valueOf(conditionTypeEnum);
        String sqlTemplate = mysqlConditionSymbolEnum.buildSql(columnName,value);
        conditionSqlTemplate.append(sqlTemplate);

        return parseResult;
    }
}
