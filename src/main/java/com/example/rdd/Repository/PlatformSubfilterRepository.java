package com.example.rdd.Repository;

import com.example.rdd.Domain.Platform.Platform;
import com.example.rdd.Domain.PlatformSubfilter.PlatformSubfilter;
import com.example.rdd.Domain.Subfilter.Subfilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatformSubfilterRepository extends JpaRepository<PlatformSubfilter, Long> {

    List<PlatformSubfilter> findSubfilterByPlatform(Platform platform);
}
