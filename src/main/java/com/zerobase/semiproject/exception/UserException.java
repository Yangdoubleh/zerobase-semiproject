package com.zerobase.semiproject.exception;

import com.zerobase.semiproject.exception.constant.UserExceptionCode;

public class UserException extends RuntimeException {
    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    public UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UserException(UserExceptionCode code) {
        super(code.getErrorCode());
    }

    public UserException(UserExceptionCode code, Throwable cause) {
        super(code.getErrorCode(), cause);
    }
}
