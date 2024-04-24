package com.redfish.common.query.engine.mysql.parse.condition;

import com.alibaba.cola.extension.Extension;
import com.redfish.common.query.engine.mysql.consts.MysqlConditionSymbolEnum;
import com.redfish.common.query.engine.mysql.entity.FieldColumnInfo;
import com.redfish.common.query.engine.mysql.parse.ParseResult;
import com.redfish.common.query.engine.mysql.entity.EntityDaoInfo;
import com.redfish.common.query.model.constans.ConditionTypeEnum;
import com.redfish.common.query.model.model.condition.SingleQueryCondition;
import com.redfish.common.query.engine.mysql.consts.ConditionParseConsts;

import javax.annotation.Resource;

@Extension(bizId = ConditionParseConsts.BIZ_Id,useCase = ConditionParseConsts.USE_CASE,scenario = "SingleQueryCondition")
public class SingleQueryConditionParserExtPt implements ConditionParserExtPt<SingleQueryCondition> {

    @Resource
    private EntityDaoInfo entityDaoInfo;

    @Override
    public ParseResult parse(SingleQueryCondition singleQueryCondition) {
        ParseResult parseResult = new ParseResult();

        StringBuilder conditionSqlTemplate = parseResult.getConditionSqlTemplate();

        String fieldCode = singleQueryCondition.getFieldCode();
        FieldColumnInfo fieldColumnInfo = entityDaoInfo.getFieldInfo(singleQueryCondition.getEntityCode(),fieldCode);
        String columnName = fieldColumnInfo.getColumnName();
        ConditionTypeEnum conditionTypeEnum = singleQueryCondition.getConditionType();


        Object value = singleQueryCondition.getValue();

        // 构建SQL
        MysqlConditionSymbolEnum mysqlConditionSymbolEnum = MysqlConditionSymbolEnum.valueOf(conditionTypeEnum);
        String sqlTemplate = mysqlConditionSymbolEnum.buildSql(columnName,value);
        conditionSqlTemplate.append(sqlTemplate);

        // 收集参数
        parseResult.addParam(mysqlConditionSymbolEnum.valueConvert(value));

        return parseResult;
    }
}
