package com.example.statistic_cache_api.controller;

import com.example.statistic_cache_api.security.AuthRequest;
import com.example.statistic_cache_api.security.AuthResponse;
import com.example.statistic_cache_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public void register(@RequestBody AuthRequest user) {
        this.userService.register(user);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse login(@RequestBody AuthRequest user) {
        return this.userService.login(user);
    }
}