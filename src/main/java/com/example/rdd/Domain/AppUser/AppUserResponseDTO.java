package com.example.rdd.Domain.AppUser;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record AppUserResponseDTO(Long id, String firstName, String lastName, String email, LocalDate birthDate, String login) {

    public AppUserResponseDTO(final AppUser user) {
        this(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getBirthDate(), user.getUsername());
    }
}
