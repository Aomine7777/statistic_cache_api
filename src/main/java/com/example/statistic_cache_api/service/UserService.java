package com.example.statistic_cache_api.service;

import com.example.statistic_cache_api.security.AuthRequest;
import com.example.statistic_cache_api.security.AuthResponse;

public interface UserService {
    void register(AuthRequest user);
    AuthResponse login(AuthRequest user);
}
