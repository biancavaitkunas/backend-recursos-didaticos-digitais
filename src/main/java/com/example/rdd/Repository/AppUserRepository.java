package com.example.rdd.Repository;

import com.example.rdd.Domain.AppUser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    UserDetails findByUsername(String username);
    Optional<AppUser> findAppUserByUsername(String username);

}
