package com.zerobase.semiproject.user.exception.constant;

import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum UserExceptionCode {
    USER_NOT_FOUND("USER_NOT_FOUND", HttpStatus.NOT_FOUND),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR),
    USERID_DUPLICATE("USERID_DUPLICATE", HttpStatus.CONFLICT);

    private String errorCode;
    private HttpStatus httpStatus;

    UserExceptionCode(String errorCode, HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public static HttpStatus getCodeToHttpStatus (String userExceptionCode) {
        return Arrays.stream(UserExceptionCode.values()).filter(item -> item.getErrorCode().equals(userExceptionCode))
                .findFirst().orElse(UserExceptionCode.INTERNAL_SERVER_ERROR).getHttpStatus();
    }
}
