package com.bezkoder.spring.jpa.postgresql.resources;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}