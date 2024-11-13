package com.example.statistic_cache_api.service.impl;

import com.example.statistic_cache_api.entity.User;
import com.example.statistic_cache_api.repository.UserRepository;
import com.example.statistic_cache_api.security.AuthRequest;
import com.example.statistic_cache_api.security.AuthResponse;
import com.example.statistic_cache_api.security.JWTUtil;
import com.example.statistic_cache_api.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JWTUtil jwtTokenUtil;

    public static final String INCORRECT_NAME_OR_PASSWORD_MESSAGE = "The name or password is incorrect.";

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void register(AuthRequest user) {
        var existUser = this.userRepository.findByUsername(user.username());
        if (isNull(existUser)) {
            this.userRepository.save(
                    new User(
                            user.username(),
                            this.passwordEncoder.encode(user.password())
                    )
            );
            log.info("Saved new user {}", user.username());
            log.info("User registered successfully with username: {}", user.username());
        } else {
            log.warn("Registration failed. Username '{}' already exists.", user.username());
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        }

    }

    @Override
    public AuthResponse login(AuthRequest user) {
        log.info("Attempting to log in user with username: {}", user.username());
        Authentication authentication;
        try {
            authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.username(), user.password()));
            log.info("User {} authenticated successfully", user.username());
        } catch (BadCredentialsException e) {
            log.warn("Authentication failed for user {}: {}", user.username(), e.getMessage());
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, INCORRECT_NAME_OR_PASSWORD_MESSAGE, e);
        }
        var jwt = this.jwtTokenUtil.generateToken((UserDetails) authentication.getPrincipal());
        log.info("JWT token generated successfully for user: {}", user.username());
        return new AuthResponse(jwt);
    }
}
