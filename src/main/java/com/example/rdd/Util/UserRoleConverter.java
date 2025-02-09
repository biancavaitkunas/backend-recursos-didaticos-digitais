package com.example.rdd.Util;

import com.example.rdd.Domain.AppUser.UserRole;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class UserRoleConverter implements AttributeConverter<UserRole, String> {

    @Override
    public String convertToDatabaseColumn(UserRole userRole) {
        if (userRole == null) {
            return null;
        }
        return userRole.getRole();
    }

    @Override
    public UserRole convertToEntityAttribute(String role) {
        if (role == null) {
            return null;
        }
        return UserRole.fromString(role);
    }
}

