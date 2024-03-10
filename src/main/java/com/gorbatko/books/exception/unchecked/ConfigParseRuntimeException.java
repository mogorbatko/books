package com.gorbatko.books.exception.unchecked;

public class ConfigParseRuntimeException extends RuntimeException{
    public ConfigParseRuntimeException(String message) {
        super(message);
    }
}
