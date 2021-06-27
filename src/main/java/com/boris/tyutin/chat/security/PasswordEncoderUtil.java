package com.boris.tyutin.chat.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderUtil {

    @Value("${password.strength}")
    private int strength;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(strength);
    }
}
