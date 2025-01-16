package com.example.rdd.Repository;

import com.example.rdd.Domain.AccessType.AccessType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessTypeRepository extends JpaRepository<AccessType, Long> {

}
