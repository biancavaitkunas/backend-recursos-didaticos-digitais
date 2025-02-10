package com.example.rdd.Domain.AppUser;

public record ChangePasswordRequest(String username, String oldPassword, String newPassword) {
}
