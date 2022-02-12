package com.dwteam.exception;

public class NotFindExp extends RuntimeException{
    public NotFindExp() {
        super();
    }

    public NotFindExp(String message) {
        super(message);
    }
}
