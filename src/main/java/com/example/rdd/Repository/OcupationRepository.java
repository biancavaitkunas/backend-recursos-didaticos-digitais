package com.example.rdd.Repository;

import com.example.rdd.Domain.Ocupation.Ocupation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcupationRepository extends JpaRepository<Ocupation, Long> {
}
