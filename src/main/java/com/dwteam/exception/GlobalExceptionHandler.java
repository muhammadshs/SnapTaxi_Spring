package com.dwteam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = NotFindExp.class)
    public ResponseEntity<?> HandlerNotFindExp(NotFindExp notFindExp){
        Map<String,Object> res=new HashMap<>();
        res.put("message",notFindExp.getMessage());
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = ConflictExp.class)
    public ResponseEntity<?> HandlerConflictExp(ConflictExp conflictExp){
        Map<String,Object> res=new HashMap<>();
        res.put("message",conflictExp.getMessage());
        return new ResponseEntity<>(res,HttpStatus.CONFLICT);
    }
}
