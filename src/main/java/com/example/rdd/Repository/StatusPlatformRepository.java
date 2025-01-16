package com.example.rdd.Repository;

import com.example.rdd.Domain.StatusPlatform.StatusPlatform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusPlatformRepository extends JpaRepository<StatusPlatform, Long> {
}
