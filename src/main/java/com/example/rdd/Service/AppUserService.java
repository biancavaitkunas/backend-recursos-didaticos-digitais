package com.example.rdd.Service;

import com.example.rdd.Domain.AppUser.AppUser;

import java.util.List;

public interface AppUserService {

    AppUser insertUser(AppUser user);

    List<AppUser> listAll();

    AppUser findById(Long id);

    AppUser updateUser(AppUser user);

    void deleteUser(Long id);

}
