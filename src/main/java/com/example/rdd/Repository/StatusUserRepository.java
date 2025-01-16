package com.example.rdd.Repository;

import com.example.rdd.Domain.StatusUser.StatusUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusUserRepository extends JpaRepository<StatusUser, Long> {
}
