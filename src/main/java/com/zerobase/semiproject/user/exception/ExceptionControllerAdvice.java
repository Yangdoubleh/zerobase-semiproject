package com.zerobase.semiproject.user.exception;

import com.zerobase.semiproject.user.exception.constant.UserExceptionCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(UserException.class)
    public Mono<ResponseEntity> userExceptionHandler(UserException e) {
        log.error("userExceptionHandler :: {}", e.getMessage());

        return Mono.just(ResponseEntity.status(UserExceptionCode.getCodeToHttpStatus(e.getMessage())).build());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Mono<ResponseEntity> illegalExceptionHandler(IllegalArgumentException e) {
        log.error("illegalExceptionHandler :: {}", e.getMessage());

        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity> exceptionHandler(Exception e) {
        log.error("exceptionHandler :: {}", e.getMessage());

        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }
}
