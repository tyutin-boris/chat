package com.boris.tyutin.chat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralControllerHandler {

    @ExceptionHandler
    public ResponseEntity userNotAuthorizedHandler(UsernameNotFoundException exception) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
