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

    public static UserRole fromString(String role) {
        for (UserRole userRole : UserRole.values()) {
            if (userRole.name().equalsIgnoreCase(role) || userRole.role.equalsIgnoreCase(role)) {
                return userRole;
            }
        }
        throw new IllegalArgumentException("No UserRole with role " + role);
    }


}
