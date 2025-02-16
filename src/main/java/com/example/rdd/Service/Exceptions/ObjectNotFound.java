package com.example.rdd.Service.Exceptions;

public class ObjectNotFound extends RuntimeException {
    public ObjectNotFound(String message) {
        super(message);
    }
}
