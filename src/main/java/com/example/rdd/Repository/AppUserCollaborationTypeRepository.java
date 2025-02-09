package com.example.rdd.Repository;

import com.example.rdd.Domain.AppUserCollaborationType.AppUserCollaborationType;
import com.example.rdd.Domain.CollaborationType.CollaborationType;
import com.example.rdd.Domain.Platform.Platform;
import com.example.rdd.Domain.PlatformSubfilter.PlatformSubfilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserCollaborationTypeRepository extends JpaRepository<AppUserCollaborationType, Long> {

    List<AppUserCollaborationType> findAppUserByCollaborationType(CollaborationType collaborationType);
}
