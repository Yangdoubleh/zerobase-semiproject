package com.zerobase.semiproject.exception;

import com.zerobase.semiproject.exception.constant.UserExceptionCode;
import io.jsonwebtoken.JwtException;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(UserException.class)
    public ResponseEntity userExceptionHandler(UserException e) {
        log.error("userExceptionHandler :: {}", e.getMessage());

        return ResponseEntity.status(UserExceptionCode.getCodeToHttpStatus(e.getMessage())).body(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity illegalExceptionHandler(IllegalArgumentException e) {
        log.error("illegalExceptionHandler :: {}", e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity entityNotFoundExceptionHandler(EntityNotFoundException e) {
        log.error("entityNotFoundExceptionHandler :: {}", e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity jwtExceptionHandler(JwtException e) {
        log.error("jwtExceptionHandler :: {}", e.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("유효하지않은 jwt token");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler(Exception e) {

        log.error("exceptionHandler :: {}", e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
