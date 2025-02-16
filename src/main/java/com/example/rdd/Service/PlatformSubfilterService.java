package com.example.rdd.Service;

import com.example.rdd.Domain.Platform.Platform;
import com.example.rdd.Domain.PlatformSubfilter.PlatformSubfilter;
import com.example.rdd.Domain.Subfilter.Subfilter;
import com.example.rdd.Repository.PlatformSubfilterRepository;
import com.example.rdd.Service.Generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformSubfilterService extends GenericService<PlatformSubfilter, Long> {

    @Autowired
    private PlatformSubfilterRepository repository;

    public List<Subfilter> getSubfiltersByPlatform(Platform platform) {
        final var filters = repository.findSubfilterByPlatform(platform);
        return filters.stream().map(PlatformSubfilter::getSubfilter).toList();
    }
}
