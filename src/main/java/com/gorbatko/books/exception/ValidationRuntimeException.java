package com.gorbatko.books.exception;

public class ValidationRuntimeException extends RuntimeException {
    public ValidationRuntimeException(String message) {
        super(message);
    }
}
