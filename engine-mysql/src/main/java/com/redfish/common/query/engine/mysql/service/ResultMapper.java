package com.redfish.common.query.engine.mysql.service;

import com.redfish.common.query.engine.mysql.entity.FieldColumnInfo;
import com.redfish.common.query.model.model.param.SelectField;
import com.redfish.common.query.model.model.result.QueryResultFieldData;
import com.redfish.common.query.model.model.result.QueryResultListData;
import com.redfish.common.query.model.model.result.QueryResultRowData;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ResultMapper {

    @Resource
    private EntityDaoInfo entityDaoInfo;


    public QueryResultListData convert(List<Map<String, Object>> rowsMap,List<SelectField>  selectFields){
        QueryResultListData queryResultListData = new QueryResultListData();
        for (Map<String, Object> rowMap:rowsMap){
            QueryResultRowData queryResultRowData = this.convert(rowMap,selectFields);
            queryResultListData.addRow(queryResultRowData);
        }
        return queryResultListData;
    }

    public QueryResultRowData convert(Map<String, Object> rowMap, List<SelectField>  selectFields){
        QueryResultRowData queryResultRowData = new QueryResultRowData();

        String entityCode = selectFields.get(0).getEntityCode();
        List<String> selectFieldCodes = selectFields.stream().map(SelectField::getFieldCode).collect(Collectors.toList());
        List<FieldColumnInfo> selectFieldColumnInfos = entityDaoInfo.getFieldInfos(entityCode,selectFieldCodes);

        selectFieldColumnInfos.forEach(fieldColumnInfo -> {
            String fieldCode = fieldColumnInfo.getFieldCode();
            Object value = rowMap.get(fieldColumnInfo.getColumnName());

            QueryResultFieldData queryResultFieldData = new QueryResultFieldData();
            queryResultFieldData.setFieldCode(fieldCode);
            queryResultFieldData.setValue(value);

            queryResultRowData.addQueryResultFieldData(queryResultFieldData);
        });


        return queryResultRowData;
    }

}
