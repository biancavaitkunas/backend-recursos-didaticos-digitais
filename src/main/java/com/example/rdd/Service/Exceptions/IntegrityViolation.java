package com.example.rdd.Service.Exceptions;

public class IntegrityViolation extends RuntimeException {

    public IntegrityViolation(final String message) {
        super(message);
    }
}
