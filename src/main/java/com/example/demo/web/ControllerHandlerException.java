package com.example.demo.web;

import com.example.demo.domain.DomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllerHandlerException {

    @ExceptionHandler(value = {DomainException.class})
    protected ResponseEntity<String> handleServiceException(DomainException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("The server has down");
    }
}