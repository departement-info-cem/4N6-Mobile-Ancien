package org.kickmyb.server;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// Va intercepter toutes les exceptions et les transformer selon la méthode en réponse http

@ControllerAdvice
public class ConfigExceptionHandling
  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
        ex.printStackTrace();

        // On prend le nom court de l'exception comme corps de la réponse HTTP 400 comme code
        String bodyOfResponse = ex.getClass().getSimpleName();
        return handleExceptionInternal(ex, bodyOfResponse, 
          new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}