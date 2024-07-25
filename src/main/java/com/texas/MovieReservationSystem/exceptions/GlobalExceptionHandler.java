package com.texas.MovieReservationSystem.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public String handleResourceNotfoundException(UserNotFoundException ex){
        String message = ex.getMessage();
        return message;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<FieldError> fieldErrors=ex.getFieldErrors();
        List<String> errors =  new ArrayList<>();
        fieldErrors.forEach(fieldError ->
        {
            String defaultMessage= fieldError.getDefaultMessage();
            errors.add(defaultMessage);
        });
        return new ResponseEntity<>(errors, headers, status);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public String handleDataIntegrityViolationException(DataIntegrityViolationException ex){
        String message = ex.getMessage();
        String regex = "unique_\\w+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(message);
        if(matcher.find()){
            String result = matcher.group();
            String substring = result.substring("unique_".length());
            String columnsName = substring.replace("_", " ");
            return columnsName + "must be unique";
        }
        return "ERROR";
    }
}
