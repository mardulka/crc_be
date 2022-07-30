package com.czechrealcup.crc_be.rest.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("Object not found.");
    }
}
