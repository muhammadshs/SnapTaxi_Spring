package com.dwteam.exception;

public class ConflictExp extends RuntimeException{
    public ConflictExp() {
        super();
    }

    public ConflictExp(String message) {
        super(message);
    }
}
