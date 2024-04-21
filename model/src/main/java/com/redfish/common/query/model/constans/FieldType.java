package com.redfish.common.query.model.constans;

public enum FieldType {

    /**
     * 物理字段
     */
    PHYSICAL("PHYSICAL", "物理字段"),

    /**
     * 计算字段
     */
    CALCULATE("CALCULATE", "计算字段")

    ;

    /**
     * 编码
     */
    private final String code;

    /**
     * 描述
     */
    private final String desc;


    FieldType(String code, String desc) {
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
