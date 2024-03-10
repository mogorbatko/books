package com.gorbatko.books.exception.checked;

public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}
