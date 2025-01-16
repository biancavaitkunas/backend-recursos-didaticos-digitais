package com.example.rdd.Repository;

import com.example.rdd.Domain.Sugestion.Sugestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugestionRepository extends JpaRepository<Sugestion, Long> {
}
