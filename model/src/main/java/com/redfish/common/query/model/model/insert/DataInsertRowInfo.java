package com.redfish.common.query.model.model.insert;

import com.redfish.common.query.model.model.param.EntityInfo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class DataInsertRowInfo implements Serializable {

    private EntityInfo entityInfo;


    private final List<DataInsertFieldInfo> dataInsertFieldInfos = new LinkedList();


    public DataInsertRowInfo addField(DataInsertFieldInfo dataInsertFieldInfo) {
        this.dataInsertFieldInfos.add(dataInsertFieldInfo);
        return this;
    }

    public List<DataInsertFieldInfo> getDataInsertFieldInfos() {
        return dataInsertFieldInfos;
    }

    public EntityInfo getEntityInfo() {
        return entityInfo;
    }

    public void setEntityInfo(EntityInfo entityInfo) {
        this.entityInfo = entityInfo;
    }



}
