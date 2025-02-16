package com.example.rdd.Service;

import com.example.rdd.Domain.Platform.Platform;
import com.example.rdd.Domain.Platform.PlatformRequestDTO;
import com.example.rdd.Domain.Platform.PlatformResponseDTO;
import com.example.rdd.Domain.PlatformSubfilter.PlatformSubfilter;
import com.example.rdd.Domain.Subfilter.Subfilter;
import com.example.rdd.Repository.PlatformRepository;
import com.example.rdd.Service.Generic.GenericService;
import com.example.rdd.Util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        final var presentationImageCreated = uploadFileService.save(requestDTO.presentationImage());
        final var textTutorialCreated = uploadFileService.save(requestDTO.textTutorial());

        final var platformCreated = repository.save(requestDTO.platform().toBuilder()
                .logo(logoCreated)
                .presentationImage(presentationImageCreated)
                .textTutorial(textTutorialCreated)
                .urlVideo(Util.convertToEmbedUrl(requestDTO.platform().getUrlVideo()))
                .build());
        requestDTO.subfilters().forEach(subfilter -> subfilterService.save(PlatformSubfilter.builder().platform(platformCreated).subfilter(subfilter).build()));

        return PlatformResponseDTO.builder()
                .name(platformCreated.getNamePlatform())
                .description(platformCreated.getDescriptionPlatform())
                .build();
    }

    public PlatformResponseDTO getPlatformDto(final Long id) {
        final var platform = repository.findById(id).orElseThrow();
        final var logoBase64 = Base64.getEncoder().encodeToString(uploadFileService.findById(platform.getLogo().getId()).orElseThrow().getImage());
        final var presentationImageBase64 = Base64.getEncoder().encodeToString(uploadFileService.findById(platform.getPresentationImage().getId()).orElseThrow().getImage());
        final var textTutorialBase64 = Base64.getEncoder().encodeToString(uploadFileService.findById(platform.getTextTutorial().getId()).orElseThrow().getImage());
        final var subfilters = subfilterService.getSubfiltersByPlatform(platform);

        return PlatformResponseDTO.builder()
                .name(platform.getNamePlatform())
                .description(platform.getDescriptionPlatform())
                .urlVideo(platform.getUrlVideo())
                .urlPlatform(platform.getUrlPlatform())
                .logo(logoBase64)
                .presentationImage(presentationImageBase64)
                .textTutorial(textTutorialBase64)
                .subfilters(subfilters.stream().map(Subfilter::getDescription).toList())
                .build();
    }

    public List<PlatformResponseDTO> getAllPlatformsDto() {
        final var platforms = repository.findAll();

        return platforms.stream().map(platform -> {
            final var logoBase64 = Base64.getEncoder().encodeToString(uploadFileService.findById(platform.getLogo().getId()).orElseThrow().getImage());
            final var presentationImageBase64 = Base64.getEncoder().encodeToString(uploadFileService.findById(platform.getPresentationImage().getId()).orElseThrow().getImage());
            final var textTutorialBase64 = Base64.getEncoder().encodeToString(uploadFileService.findById(platform.getTextTutorial().getId()).orElseThrow().getImage());
            final var subfilters = subfilterService.getSubfiltersByPlatform(platform);
            return PlatformResponseDTO.builder()
                    .id(platform.getId())
                    .name(platform.getNamePlatform())
                    .description(platform.getDescriptionPlatform())
                    .urlVideo(platform.getUrlVideo())
                    .urlPlatform(platform.getUrlPlatform())
                    .presentationImage(presentationImageBase64)
                    .textTutorial(textTutorialBase64)
                    .logo(logoBase64)
                    .subfilters(subfilters.stream().map(Subfilter::getDescription).toList())
                    .build();
        }).toList();
    }
}
