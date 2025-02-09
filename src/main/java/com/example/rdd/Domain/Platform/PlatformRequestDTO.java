package com.example.rdd.Domain.Platform;

import com.example.rdd.Domain.Subfilter.Subfilter;
import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Builder
public record PlatformRequestDTO(Platform platform, MultipartFile logo, MultipartFile presentationImage, MultipartFile textTutorial, List<Subfilter> subfilters) {
}
