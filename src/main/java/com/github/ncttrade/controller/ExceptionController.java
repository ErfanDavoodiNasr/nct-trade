package com.github.ncttrade.controller;


import com.github.ncttrade.exception.InvalidSymbolException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(InvalidSymbolException.class)
    public ResponseEntity<String> invalidSymbolException(
            InvalidSymbolException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
