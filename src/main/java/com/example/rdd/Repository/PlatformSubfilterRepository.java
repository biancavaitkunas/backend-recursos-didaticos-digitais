package com.example.rdd.Repository;

import com.example.rdd.Domain.PlatformSubfilter.PlatformSubfilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformSubfilterRepository extends JpaRepository<PlatformSubfilter, Long> {
}
