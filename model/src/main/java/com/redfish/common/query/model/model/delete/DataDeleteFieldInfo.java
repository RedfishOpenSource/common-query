package com.redfish.common.query.model.model.delete;

import java.io.Serializable;
import java.util.List;

public class DataDeleteFieldInfo implements Serializable {

    /**
     * 数据唯一键字段
     */
    private String fieldCode;

    /**
     * 支持列表形式接受，支持批量删除
     */
    private Object value;

}
