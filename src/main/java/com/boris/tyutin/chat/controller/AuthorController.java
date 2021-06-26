package com.boris.tyutin.chat.controller;

import com.boris.tyutin.chat.model.entity.User;
import com.boris.tyutin.chat.model.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthorController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public AuthorController(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
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
        User user = User.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
        userService.save(user);
        return ResponseEntity.ok().build();
    }
}
