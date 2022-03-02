package com.dwteam.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// base exp
//model exp
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = BaseExp.class)
    public ResponseEntity<?> HandlerNotFindExp(BaseExp baseExp) {

        return new ResponseEntity<>(baseExp.mainExp(), baseExp.mainExp().getHttpStatus());
    }

}
