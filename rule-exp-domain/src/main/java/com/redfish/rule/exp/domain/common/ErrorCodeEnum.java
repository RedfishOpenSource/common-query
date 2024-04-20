package com.redfish.rule.exp.domain.common;

public enum ErrorCodeEnum {

    /**
     * 数据已存在
     */
    DATA_EXISTS("dataExists","数据已存在"),
    /**
     * 数据已存在
     */
    PARAM_ERROR("paramError","参数异常");


    /**
     * 编码
     */
    private String code;

    /**
     * 描述
     */
    private String desc;

    ErrorCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
