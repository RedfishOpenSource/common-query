package com.redfish.common.query.model.constans;


public enum ConditionTypeEnum {
    /**
     * condition type
     */
    EQUAL("eq", "等于"),

    NOT_EQUAL("ne", "不等于"),

    LESS_THAN("lt", "小于"),

    LESS_THAN_OR_EQUAL("le", "小于等于"),

    GREATER_THAN("gt", "大于"),

    GREATER_THAN_OR_EQUAL("ge", "大于等于"),



    LIKE("like", "模糊查询"),

    NOT_LIKE("not_like", "模糊查询"),

    LEFT_LIKE("left_like", "模糊查询"),

    RIGHT_LIKE("right_like", "模糊查询"),



    BETWEEN_II("betweenII", "在范围内，包含开始与结束点（闭区间）"),


    BETWEEN_EE("betweenEE", " 在范围内，不包含开始与结束点（开区间）"),


    BETWEEN_EI("betweenEI"," 在范围内，不包含开始点，包含结束点（左开右闭区间）"),


    BETWEEN_IE("betweenIE", "在范围内，包含开始点，不包含结束点（左闭右开区间）"),



    IN("in", "包含"),

    NOT_IN("not_in", "不包含"),



    IS_NULL("is_null", "为空"),

    IS_NOT_NULL("is_not_null", "不为空"),



    IS_EMPTY("is_empty", "为空"),

    IS_NOT_EMPTY("is_not_empty", "不为空")


    ;

    ConditionTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private final String code;


    private final String msg;


    public static ConditionTypeEnum valueOfCode(String code) {
        for (ConditionTypeEnum value : ConditionTypeEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        throw new RuntimeException("这个枚举不存在");
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
