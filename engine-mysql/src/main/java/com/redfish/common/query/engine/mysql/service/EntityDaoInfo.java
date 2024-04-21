package com.redfish.common.query.engine.mysql.service;

import com.redfish.common.query.engine.mysql.entity.FieldColumnInfo;
import com.redfish.common.query.model.model.param.EntityInfo;

import java.util.List;


/**
 * 根据查询param获取物理信息，如根据entityCode获取tableName
 */
public interface EntityDaoInfo {

    /**
     * 根据实体获取物理表名
     *
     * @param entityCode
     * @return
     */
    String getTableName(String entityCode);

    /**
     * 根据字段编码，获取字段信息
     *
     * @param entityCode
     * @param fieldCode
     * @return
     */
    FieldColumnInfo getFieldInfo(String entityCode, String fieldCode);

    List<FieldColumnInfo> getFieldInfos(String entityCode, List<String> fieldCodes);
}
