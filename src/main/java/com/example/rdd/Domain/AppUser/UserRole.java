package com.example.rdd.Domain.AppUser;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRole {

    ADMIN("admin"),
    PARTNER("colaborador"),
    USER("user");

    private final String role;

}
