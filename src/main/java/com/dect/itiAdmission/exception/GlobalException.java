package com.dect.itiAdmission.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException extends RuntimeException{
    @ExceptionHandler(DataInsertionException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleDataInsertionException(DataInsertionException exception){
        return exception.getMessage();
    }
    @ExceptionHandler(ApplicantAlreadyExists.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleApplicantAlreadyExists(ApplicantAlreadyExists exception){
        return exception.getMessage();
    }

    @ExceptionHandler(ApplicantNotPresent.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleApplicantNotPresent(ApplicantNotPresent exception){
        return exception.getMessage();
    }
}
