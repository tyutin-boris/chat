package com.boris.tyutin.chat.exception.exeptions;

public class UserPresent extends RuntimeException {
    public UserPresent(String message) {
        super(message);
    }
}
