package com.zerobase.semiproject.user.exception.constant;

public enum UserExceptionCode {
    USER_NOT_FOUND("USER_NOT_FOUND"),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR"),
    USERID_DUPLICATE("USERID_DUPLICATE");

    private String errorCode;

    UserExceptionCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
