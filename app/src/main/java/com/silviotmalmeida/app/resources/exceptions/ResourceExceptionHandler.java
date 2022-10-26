package com.silviotmalmeida.app.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.silviotmalmeida.app.services.exceptions.ObjectNotFoundException;


// classe para interceptação e tratamento manual dos erros
// a anotação @ControllerAdvice ativa a interceptação das exceções por esta classe
@ControllerAdvice
public class ResourceExceptionHandler {

    // método que vai interceptar e tratar todas as exceções do tipo
    // ObjectNotFoundException
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        // definindo o erro
        String error = "Object not found";

        // definindo o código do erro
        HttpStatus status = HttpStatus.NOT_FOUND;

        // criando o erro customizado
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());

        // retornando o erro customizado
        return ResponseEntity.status(status).body(err);
    }
}
