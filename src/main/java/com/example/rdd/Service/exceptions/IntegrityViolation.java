package com.example.rdd.Service.exceptions;

public class IntegrityViolation extends RuntimeException {

    public IntegrityViolation(final String message) {
        super(message);
    }
}
