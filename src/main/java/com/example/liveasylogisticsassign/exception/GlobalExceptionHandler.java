package com.example.liveasylogisticsassign.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<String> exception(CustomException e){
        return ResponseEntity.internalServerError().body(e.getLocalizedMessage());
    }
}
