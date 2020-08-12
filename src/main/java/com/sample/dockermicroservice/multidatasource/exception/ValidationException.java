package com.sample.dockermicroservice.multidatasource.exception;

public class ValidationException extends Exception{

    private final String message;

    public ValidationException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    
    
}
