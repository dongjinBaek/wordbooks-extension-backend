package com.dongjinbaek.wordbooks.controller;

import com.dongjinbaek.wordbooks.exception.InvalidPasswordException;
import com.dongjinbaek.wordbooks.exception.NoSuchUserException;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void handleDuplicateKey() {
        return;
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleBadRequest() {
        return;
    }

    @ExceptionHandler(NoSuchUserException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void noSuchUser() {
        return;
    }

    @ExceptionHandler(InvalidPasswordException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void invalidPassword() {
        return;
    }
}