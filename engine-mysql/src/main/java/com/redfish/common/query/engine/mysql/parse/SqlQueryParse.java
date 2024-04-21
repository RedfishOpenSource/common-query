package com.redfish.common.query.engine.mysql.parse;

import com.redfish.common.query.engine.mysql.entity.FieldColumnInfo;
import com.redfish.common.query.engine.mysql.parse.condition.ConditionParseExe;
import com.redfish.common.query.engine.mysql.service.EntityDaoInfo;
import com.redfish.common.query.model.constans.FieldType;
import com.redfish.common.query.model.model.param.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class SqlQueryParse {

    @Resource
    private EntityDaoInfo entityDaoInfo;

    @Resource
    private ConditionParseExe conditionParseExe;

    public ParseResult parse(CountQueryParam countQueryParam) {
        ParseResult parseResult = new ParseResult();
        StringBuilder sqlBuilder = parseResult.getConditionSqlTemplate();

        EntityInfo entityInfo = countQueryParam.getEntityInfo();

        // select 信息
        sqlBuilder.append("select count(1)");

        // 表信息
        sqlBuilder.append(addFrom(entityInfo));

        // 条件信息
        ParseResult conditionParseResult = conditionParseExe.parse(countQueryParam.getQueryCondition());
        sqlBuilder.append(" where ");
        sqlBuilder.append(conditionParseResult.getConditionSqlTemplate());
        parseResult.addParam(conditionParseResult.getParams());


        sqlBuilder.append(";");
        return parseResult;
    }

   public ParseResult parse(PageQueryParam pageQueryParam) {
       ParseResult parseResult = new ParseResult();
       StringBuilder sqlBuilder = parseResult.getConditionSqlTemplate();

       EntityInfo entityInfo = pageQueryParam.getEntityInfo();

       List<SelectField> selectFields = pageQueryParam.getSelectFields();
       List<String> selectFieldCodes = selectFields.stream()
               .filter(selectFieldInner -> selectFieldInner.getFieldType() == FieldType.PHYSICAL)
               .map(SelectField::getFieldCode).collect(Collectors.toList());
       List<FieldColumnInfo> selectFieldColumnInfos = entityDaoInfo.getFieldInfos(entityInfo.getEntityCode(),selectFieldCodes);
       List<String> selectColumnFieldCodes = selectFieldColumnInfos.stream().map(FieldColumnInfo::getColumnName).collect(Collectors.toList());

       // 查询字段信息
       sqlBuilder.append("select ");
       sqlBuilder.append(String.join(",",selectColumnFieldCodes));

       // 表信息
       sqlBuilder.append(addFrom(entityInfo));

       // 条件信息
       ParseResult conditionParseResult = conditionParseExe.parse(pageQueryParam.getQueryCondition());
       sqlBuilder.append(" where ");
       sqlBuilder.append(conditionParseResult.getConditionSqlTemplate());
       parseResult.addParam(conditionParseResult.getParams());

       sqlBuilder.append(addSorInfo(pageQueryParam.getSortInfos()));

       // 分页信息
       sqlBuilder.append(addPageInfo(pageQueryParam.getPageInfo()));

       sqlBuilder.append(";");
       return parseResult;
   }

    private String addFrom(EntityInfo entityInfo) {
        StringBuilder fromFuilder = new StringBuilder();

        String tableName = entityDaoInfo.getTableName(entityInfo.getEntityCode());
        fromFuilder.append(" from ");
        fromFuilder.append(tableName);

        return fromFuilder.toString();
    }


    private String addSorInfo(List<SortInfo> sortInfos) {
       sortInfos = sortInfos.stream().sorted(Comparator.comparingInt(SortInfo::getSortNum)).collect(Collectors.toList());

       String entityCode = sortInfos.get(0).getEntityCode();
       List<String> sortFieldCodes = sortInfos.stream().map(SortInfo::getFieldCode).collect(Collectors.toList());
       List<FieldColumnInfo> selectFieldColumnInfos = entityDaoInfo.getFieldInfos(entityCode,sortFieldCodes);
       Map<String,FieldColumnInfo> fieldCodeToCloumnInfoMap = selectFieldColumnInfos.stream()
               .collect(Collectors.toMap(FieldColumnInfo::getFieldCode, Function.identity(),(pre, next)->next));

       StringBuilder sqlBuilder = new StringBuilder();
       sqlBuilder.append(" order by ");
       for(int i=0;i<sortInfos.size();i++){
           SortInfo sortInfoItem = sortInfos.get(i);

           if (i!=0){
               sqlBuilder.append(",");
           }

           FieldColumnInfo fieldColumnInfoItem = fieldCodeToCloumnInfoMap.get(sortInfoItem.getFieldCode());
           sqlBuilder.append(fieldColumnInfoItem.getColumnName());
           sqlBuilder.append(" ");
           sqlBuilder.append(sortInfoItem.getSortConditionEnum().getCode());
       }

       return sqlBuilder.toString();
    }


    /**
     * 添加分页信息
     *
     * @param pageInfo
     */
    private String addPageInfo(PageInfo pageInfo) {
        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append(" limit ");
        sqlBuilder.append(pageInfo.getOffset());
        sqlBuilder.append(",");
        sqlBuilder.append(pageInfo.getPageSize());

        return sqlBuilder.toString();
    }



}
