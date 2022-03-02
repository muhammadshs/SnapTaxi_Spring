package com.dwteam.exception;

import org.springframework.http.HttpStatus;

public class NotFindExp extends BaseExp{
    String massage,className;
    public NotFindExp(String massage,String className) {
        this.massage=massage;
        this.className=className;
    }

    @Override
    public ExpDto mainExp() {
        return new ExpDto(massage, HttpStatus.NOT_FOUND,className);
    }
}
