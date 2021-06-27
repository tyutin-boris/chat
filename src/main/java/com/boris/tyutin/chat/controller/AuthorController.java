package com.boris.tyutin.chat.controller;

import com.boris.tyutin.chat.exception.exeptions.UserPresent;
import com.boris.tyutin.chat.model.entity.User;
import com.boris.tyutin.chat.model.service.UserService;
import com.boris.tyutin.chat.security.PasswordEncoderUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthorController {

    private final UserService userService;
    private final PasswordEncoderUtil encoderUtil;
    private final AuthenticationManager authenticationManager;

    public AuthorController(AuthenticationManager authenticationManager,
                            UserService userService, PasswordEncoderUtil encoderUtil) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.encoderUtil = encoderUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(email, password));
        SecurityContextHolder.getContext().setAuthentication(auth);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout() {
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reg")
    public ResponseEntity<?> reg(@RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam String password) {

        userService.findByEmail(email)
                .ifPresent(user -> {
                    throw new UserPresent("User with this " + email + " is already registered");
                });

        User user = User.builder()
                .name(name)
                .email(email)
                .password(encoderUtil.passwordEncoder().encode(password))
                .build();
        userService.save(user);
        return ResponseEntity.ok().build();
    }
}
