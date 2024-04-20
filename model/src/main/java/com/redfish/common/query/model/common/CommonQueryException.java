package com.redfish.common.query.model.common;

public class CommonQueryException extends RuntimeException{

    /**
     * 异常类型
     */
    private ErrorCodeEnum errorCodeEnum;

    public CommonQueryException(ErrorCodeEnum errorCodeEnum, String message) {
        super(message);
        this.errorCodeEnum = errorCodeEnum;
    }

    public ErrorCodeEnum getErrorCodeEnum() {
        return errorCodeEnum;
    }

}
