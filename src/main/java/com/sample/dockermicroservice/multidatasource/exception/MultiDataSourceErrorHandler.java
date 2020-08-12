
package com.sample.dockermicroservice.multidatasource.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MultiDataSourceErrorHandler {
    
    private static final String VALIDATION_ERROR = "VALIDATION_ERROR";


    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ErrorResponse handleUserNotFoundException(IllegalArgumentException e) {
        return new ErrorResponse(VALIDATION_ERROR, "Resource Not Found");
    }

    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    @ExceptionHandler(value = ValidationException.class)
    public ErrorResponse handleValidationException(ValidationException e) {
        return new ErrorResponse(VALIDATION_ERROR, e.getMessage());
    }
    
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ErrorResponse handleException(Exception e) {
        return new ErrorResponse("GENERAL_ERROR", e.getMessage());
    }
}
