package com.ruanscherer.springboot_mongodb.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(final String message) {
        super(message);
    }
}
