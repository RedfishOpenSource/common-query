package com.redfish.common.query.model.model.insert;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * 支持插入多行
 */
public class DataInsertParam implements Serializable {

    private final List<DataInsertRowInfo> dataInsertRowInfos = new LinkedList<>();

    public DataInsertParam addRow(DataInsertRowInfo dataInsertRowInfo) {
        this.dataInsertRowInfos.add(dataInsertRowInfo);
        return this;
    }

    public List<DataInsertRowInfo> getDataInsertRowInfos() {
        return dataInsertRowInfos;
    }
}
