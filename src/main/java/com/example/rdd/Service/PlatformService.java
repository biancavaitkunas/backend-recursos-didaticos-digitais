package com.example.rdd.Service;

import com.example.rdd.Domain.Platform.Platform;
import com.example.rdd.Domain.Platform.PlatformRequestDTO;
import com.example.rdd.Domain.Platform.PlatformResponseDTO;
import com.example.rdd.Domain.PlatformSubfilter.PlatformSubfilter;
import com.example.rdd.Repository.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class PlatformService extends GenericService<Platform, Long> {

    @Autowired
    private PlatformRepository repository;

    @Autowired
    private UploadFileService uploadFileService;

    @Autowired
    private PlatformSubfilterService subfilterService;

    public PlatformResponseDTO createPlatformWithLogoAndSubfilters(final PlatformRequestDTO requestDTO) throws IOException {
        final var logoCreated = uploadFileService.save(requestDTO.logo());
        final var platformCreated = repository.save(requestDTO.platform().toBuilder().logo(logoCreated).build());
        requestDTO.subfilters().forEach(subfilter -> subfilterService.save(PlatformSubfilter.builder().platform(platformCreated).subfilter(subfilter).build()));

        return PlatformResponseDTO.builder()
                .name(platformCreated.getNamePlatform())
                .description(platformCreated.getDescriptionPlatform())
                .build();
    }

    public PlatformResponseDTO getPlatformDto(final Long id) {
        final var platform = repository.findById(id).orElseThrow();
        final var logoBase64 = Base64.getEncoder().encodeToString(uploadFileService.findById(platform.getLogo().getId()).orElseThrow().getImage());
        return PlatformResponseDTO.builder()
                .name(platform.getNamePlatform())
                .description(platform.getDescriptionPlatform())
                .logo(logoBase64)
                .build();
    }

    public List<PlatformResponseDTO> getAllPlatformsDto() {
        final var platforms = repository.findAll();

        return platforms.stream().map(platform -> {
            final var logoBase64 = Base64.getEncoder().encodeToString(uploadFileService.findById(platform.getLogo().getId()).orElseThrow().getImage());
            return PlatformResponseDTO.builder()
                    .name(platform.getNamePlatform())
                    .description(platform.getDescriptionPlatform())
                    .logo(logoBase64)
                    .build();
        }).toList();
    }
}
