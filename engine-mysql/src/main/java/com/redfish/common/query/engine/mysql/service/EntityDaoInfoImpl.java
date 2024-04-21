package com.redfish.common.query.engine.mysql.service;

import com.redfish.common.query.engine.mysql.entity.FieldColumnInfo;
import com.redfish.common.query.model.constans.FieldType;
import com.redfish.common.query.model.model.param.EntityInfo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class EntityDaoInfoImpl implements EntityDaoInfo{


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
