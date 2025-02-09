package com.example.rdd.Domain.Platform;

import com.example.rdd.Domain.Subfilter.Subfilter;
import com.example.rdd.Service.PlatformSubfilterService;
import lombok.Builder;

import java.util.List;

@Builder
public record PlatformResponseDTO(Long id, String name, String description, String urlVideo, String urlPlatform, String logo, String presentationImage, String textTutorial, List<String> subfilters) {

    static PlatformSubfilterService platformSubfilterService;

    public PlatformResponseDTO(final Platform platform, final String logo, final String presentationImage, final String textTutorial) {
        this(platform.getId(), platform.getNamePlatform(), platform.getDescriptionPlatform(), platform.getUrlVideo(), platform.getUrlPlatform(), logo, presentationImage, textTutorial, platformSubfilterService.getSubfiltersByPlatform(platform).stream().map(Subfilter::getDescription).toList());
    }

    public PlatformResponseDTO(final Platform platform) {
        this(platform.getId(), platform.getNamePlatform(), platform.getDescriptionPlatform(), platform.getUrlVideo(), platform.getUrlPlatform(), null, null, null, null);
    }
}
