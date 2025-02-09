package com.example.rdd.Domain.AppUser;

import java.time.LocalDate;

public record AppUserRequestDTO(String firstName, String lastName, String email, String cpf, String username, LocalDate birthDate, String gender) {
}
