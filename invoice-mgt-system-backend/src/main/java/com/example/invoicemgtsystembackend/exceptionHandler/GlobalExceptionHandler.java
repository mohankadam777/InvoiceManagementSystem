package com.example.invoicemgtsystembackend.exceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.invoicemgtsystembackend.model.ErrorMessage;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //Generic exception handler
    @ExceptionHandler(value ={Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ErrorMessage defaultErrorHandler(HttpServletRequest request, Exception ex){
        ErrorMessage errorMessage = ErrorMessage.builder()
        .message(ex.getMessage())
        .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR.name())
        .timestamp(LocalDateTime.now())
        .build();
        return errorMessage;
    }

    // Custom Exception Handler
    @ExceptionHandler(value ={GenericException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ErrorMessage handleGenericException(HttpServletRequest request, GenericException ex){
        ErrorMessage errorMessage = ErrorMessage.builder()
        .message(ex.getMessage())
        .httpStatus(HttpStatus.NOT_FOUND.name())
        .timestamp(LocalDateTime.now())
        .build();
        return errorMessage;
        
    }
}
