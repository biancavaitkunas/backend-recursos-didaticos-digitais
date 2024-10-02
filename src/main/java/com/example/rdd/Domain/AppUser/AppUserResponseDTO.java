package com.example.rdd.Domain.AppUser;

import java.time.LocalDate;

public record AppUserResponseDTO(Long id, String firstName, String lastName, String email, LocalDate birthDate) {

    public AppUserResponseDTO(final AppUser user) {
        this(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getBirthDate());
    }
}
