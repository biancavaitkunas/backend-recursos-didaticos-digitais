package com.example.rdd.Repository;

import com.example.rdd.Domain.CollaborationType.CollaborationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaborationTypeRepository extends JpaRepository<CollaborationType, Long> {
}
