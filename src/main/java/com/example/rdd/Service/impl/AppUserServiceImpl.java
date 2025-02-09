package com.example.rdd.Service.impl;

import com.example.rdd.Repository.AppUserRepository;
import com.example.rdd.Service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl extends AppUserService {

    @Autowired
    AppUserRepository repository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        final var user = repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
//        return User.builder()
//                .username(user.getUsername())
//                .password(user.getPassword())
//                .roles(user.getRole().name())
//                .build();
//    }

}
