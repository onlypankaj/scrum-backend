package com.mytest.scrum.exception;

public class RetrospectiveNotFoundException extends RuntimeException{
    public RetrospectiveNotFoundException() {
        super("No data found");
    }
}
