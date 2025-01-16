//package com.example.rdd.Service;
//
//import com.example.rdd.Repository.AppUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class AuthorizationService implements UserDetailsService {
//
//    @Autowired
//    AppUserRepository repository;
//
//    @Override
//    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
//        return repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
//    }
//}
