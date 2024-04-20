package com.redfish.rule.exp.domain.common;

public class ExpException extends RuntimeException{

    /**
     * 异常类型
     */
    private ErrorCodeEnum errorCodeEnum;

    public ExpException(ErrorCodeEnum errorCodeEnum,String message) {
        super(message);
        this.errorCodeEnum = errorCodeEnum;
    }

    public ErrorCodeEnum getErrorCodeEnum() {
        return errorCodeEnum;
    }

}
