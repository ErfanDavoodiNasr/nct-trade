package com.github.ncttrade.forex.controller;


import com.github.ncttrade.forex.exception.InvalidSymbolException;
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
