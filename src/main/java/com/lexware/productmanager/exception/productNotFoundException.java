package com.lexware.productmanager.exception;

public class productNotFoundException extends RuntimeException{
    public productNotFoundException(String message) {
        super(message);
    }
}
