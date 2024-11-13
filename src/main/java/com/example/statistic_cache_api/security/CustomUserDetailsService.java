package com.example.statistic_cache_api.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import com.example.statistic_cache_api.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var myUser = userRepository.findByUsername(username);
        if (isNull(myUser)) {
            throw new UsernameNotFoundException("User with username " + username + " not found!");
        }
        log.info("Loading user by username {}", username);

        return User.builder()
                .username(myUser.getUsername())
                .password(myUser.getPassword())
                .roles(myUser.getRole().toString())
                .build();
    }
}