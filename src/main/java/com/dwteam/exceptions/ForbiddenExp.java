package com.dwteam.exceptions;

import org.springframework.http.HttpStatus;

public class ForbiddenExp extends BaseExp{
    private String massage;
    private String className;

    public ForbiddenExp(String massage, String className) {
        this.massage = massage;
        this.className = className;
    }

    @Override
    public ExpDto mainExp() {
        return new ExpDto(massage, HttpStatus.FORBIDDEN,className);
    }
}
