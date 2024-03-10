package com.gorbatko.books.exception.unchecked;

public class CSVServiceRuntimeException extends RuntimeException {
    public CSVServiceRuntimeException(String message) {
        super(message);
    }
}
