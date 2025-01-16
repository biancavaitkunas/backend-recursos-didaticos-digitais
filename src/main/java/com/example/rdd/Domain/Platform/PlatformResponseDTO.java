package com.example.rdd.Domain.Platform;

import com.example.rdd.Domain.UploadFile.UploadFile;
import lombok.Builder;

@Builder
public record PlatformResponseDTO(String name, String description, String urlVideo, String urlPlatform, String logo) {

    public PlatformResponseDTO(final Platform platform, final String logo) {
        this(platform.getNamePlatform(), platform.getDescriptionPlatform(), platform.getUrlVideo(), platform.getUrlPlatform(), logo);
    }

    public PlatformResponseDTO(final Platform platform) {
        this(platform.getNamePlatform(), platform.getDescriptionPlatform(), platform.getUrlVideo(), platform.getUrlPlatform(), null);
    }
}
