package com.example.rdd.Service;

import com.example.rdd.Domain.AppUser.AppUser;
import com.example.rdd.Domain.AppUser.AppUserDetails;
import com.example.rdd.Repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class AppUserService extends GenericService<AppUser, Long> /*implements UserDetailsService*/ {


    @Autowired
    AppUserRepository repository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return repository.loadUserByUsername(username);
//    }
//
//    public AppUser create(final AppUser entity) {
//        final var encodedPassword = passwordEncoder.encode(entity.getPassword());
//        final var user = entity.toBuilder()
//                .password(encodedPassword)
//                .build();
//        return repository.save(user);
//    }
}
