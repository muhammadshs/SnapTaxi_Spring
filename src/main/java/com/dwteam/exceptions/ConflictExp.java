package com.dwteam.exceptions;

import org.springframework.http.HttpStatus;

public class ConflictExp extends BaseExp{
    String className,massage;

    public ConflictExp(String className, String massage) {
        this.className = className;
        this.massage = massage;
    }

    @Override
    public ExpDto mainExp() {
        return new ExpDto(massage, HttpStatus.CONFLICT,className);
    }
}
