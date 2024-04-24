package com.redfish.common.query.engine.mysql.entity;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@ConditionalOnProperty(name = "common.query.entity.dao.strategy",havingValue = "default", matchIfMissing = true)
@Component
public class DefaultEntityDaoInfoImpl implements EntityDaoInfo{


    @Override
    public String getTableName(String entityCode) {
        return entityCode;
    }

    @Override
    public FieldColumnInfo getFieldInfo(String entityCode, String fieldCode) {
        FieldColumnInfo fieldColumnInfo = new FieldColumnInfo();
        fieldColumnInfo.setFieldCode(fieldCode);
        fieldColumnInfo.setColumnName(fieldCode);
        fieldColumnInfo.setEntityCode(entityCode);

        return fieldColumnInfo;
    }


    @Override
    public List<FieldColumnInfo> getFieldInfos(String entityCode, List<String> fieldCodes) {
        return fieldCodes.stream().map(fieldCode -> getFieldInfo(entityCode,fieldCode)).collect(Collectors.toList());
    }

}
