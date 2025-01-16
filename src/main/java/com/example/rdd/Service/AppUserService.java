package com.example.rdd.Service;

import com.example.rdd.Domain.AppUser.AppUser;
import com.example.rdd.Repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService extends GenericService<AppUser, Long> {

    @Autowired
    AppUserRepository repository;

    public List<AppUser> findByLogin(final String login) {
        return repository.findByLogin(login);
    }

}
