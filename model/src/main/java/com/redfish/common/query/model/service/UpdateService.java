package com.redfish.common.query.model.service;

import com.redfish.common.query.model.model.update.DataUpdateParam;

public interface UpdateService {

    /**
     * 如果value为null，则更新字段为null
     *
     * @param dataUpdateParam
     * @return
     */
    Boolean update(DataUpdateParam dataUpdateParam);

    /**
     * 如果value为null，则不更新字段。
     *
     * @param dataUpdateParam
     * @return
     */
    Boolean updateSelective(DataUpdateParam dataUpdateParam);

}
