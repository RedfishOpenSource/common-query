package com.redfish.common.query.model.service;

import com.redfish.common.query.model.model.insert.DataInsertParam;

public interface InsertService {

    /**
     * 批量插入多条数据
     * 插入成功后，回向DataInsertRowInfo中添加一个fieldCode=id的DataInsertFieldInfo，填充刚刚新增得到的id。
     *
     * @param dataInsertParam
     * @return
     */
    Boolean batchInsert(DataInsertParam dataInsertParam);

}
