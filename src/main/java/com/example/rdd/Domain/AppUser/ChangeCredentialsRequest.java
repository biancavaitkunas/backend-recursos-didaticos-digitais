package com.example.rdd.Domain.AppUser;

import com.example.rdd.Domain.CollaborationType.CollaborationType;
import com.example.rdd.Domain.Permission.Permission;

import java.util.List;

public record ChangeCredentialsRequest(AppUser appUser, List<CollaborationType> collaborations, UserRole newRole, List<Permission> permissions) {
}
