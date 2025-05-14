package com.bootcamp.dio.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handler(IllegalArgumentException businessException){
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);// Erro: 422
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handler(NoSuchElementException serviceException){
        return new ResponseEntity<>("ID não encontrado.", HttpStatus.NOT_FOUND);//Erro: 404
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handler(Throwable unexpectedException){
        var message = "Erro inesperado no servidor, analise os logs";
        logger.error(message, unexpectedException);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);//Erro: 404
    }


}
