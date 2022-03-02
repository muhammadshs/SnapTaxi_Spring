package com.dwteam.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class ExpDto {
    private String massage;
    private HttpStatus httpStatus;
    private String className;

    public ExpDto(String massage, HttpStatus httpStatus, String className) {
        this.massage = massage;
        this.httpStatus = httpStatus;
        this.className = className;
    }


}
