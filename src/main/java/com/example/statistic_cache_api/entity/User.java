package com.example.statistic_cache_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static com.example.statistic_cache_api.entity.RoleType.USER;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private RoleType role;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = USER;
    }
}