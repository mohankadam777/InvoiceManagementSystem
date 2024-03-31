package com.example.invoicemgtsystembackend.exceptionHandler;

import org.springframework.http.HttpStatus;
import lombok.Data;

@Data
public class GenericException extends RuntimeException  {
    private HttpStatus status;

    public GenericException(String errorMessage , HttpStatus status, Throwable cause){
        super(errorMessage,cause);
        this.status = status;
    }
    
    public GenericException(String errorMessage , HttpStatus status){
        super(errorMessage);
        this.status = status;
    }
}
