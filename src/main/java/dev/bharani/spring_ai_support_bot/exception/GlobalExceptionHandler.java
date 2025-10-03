package dev.bharani.spring_ai_support_bot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<String> handleMissingHeader(MissingRequestHeaderException ex) {
        String headerName = ex.getHeaderName();
        String message = "Required header '" + headerName + "' is missing.";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

}
