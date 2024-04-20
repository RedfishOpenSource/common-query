package com.redfish.common.query.model.model.update;

import com.redfish.common.query.model.model.param.EntityInfo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class DataUpdateParam implements Serializable {

    private EntityInfo entityInfo;

    private DataUpdateFieldInfo idFieldInfo;

    private final List<DataUpdateFieldInfo> dataUpdateFieldInfos = new LinkedList<>();


    public DataUpdateParam addField(DataUpdateFieldInfo dataUpdateFieldInfo) {
        dataUpdateFieldInfos.add(dataUpdateFieldInfo);
        return this;
    }

    public EntityInfo getEntityInfo() {
        return entityInfo;
    }

    public void setEntityInfo(EntityInfo entityInfo) {
        this.entityInfo = entityInfo;
    }

    public DataUpdateFieldInfo getIdFieldInfo() {
        return idFieldInfo;
    }

    public void setIdFieldInfo(DataUpdateFieldInfo idFieldInfo) {
        this.idFieldInfo = idFieldInfo;
    }

    public List<DataUpdateFieldInfo> getDataUpdateFieldInfos() {
        return dataUpdateFieldInfos;
    }
}
