package com.boris.tyutin.chat.exception;

import com.boris.tyutin.chat.exception.exeptions.UserPresent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralControllerHandler {

    @ExceptionHandler
    public ResponseEntity userHandler(UsernameNotFoundException exception) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> registrationHandler(UserPresent exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
