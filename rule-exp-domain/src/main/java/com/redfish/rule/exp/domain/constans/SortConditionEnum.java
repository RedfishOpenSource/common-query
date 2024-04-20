package com.redfish.rule.exp.domain.constans;




public enum SortConditionEnum {

    ASC("ASC", "升序"),

    DESC("DESC", "降序"),

    ;


    private String code;


    private String msg;

    SortConditionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static SortConditionEnum valueOfCode(String code) {
        for (SortConditionEnum value : SortConditionEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }


}

