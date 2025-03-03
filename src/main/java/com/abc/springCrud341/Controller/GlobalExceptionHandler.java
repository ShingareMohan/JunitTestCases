package com.abc.springCrud341.Controller;

import com.abc.springCrud341.Entity.ErrorResponse;
import com.abc.springCrud341.Exception1.ResourceNoFoundException;
import oracle.core.lmx.CoreException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNoFoundException.class)
public ResponseEntity<?> handleResourceNotFound(ResourceNoFoundException ex) {

        ErrorResponse e1 = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),"Book not found", ex.getMessage());
       return new  ResponseEntity<>(e1,HttpStatus.NOT_FOUND);
    }
}
