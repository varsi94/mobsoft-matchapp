package com.mobsoft.matchapp.repository.exceptions;

/**
 * Created by mobsoft on 2017. 04. 10..
 */

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
