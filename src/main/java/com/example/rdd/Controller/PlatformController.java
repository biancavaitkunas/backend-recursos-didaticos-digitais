package com.example.rdd.Controller;

import com.example.rdd.Controller.Generic.GenericController;
import com.example.rdd.Domain.Platform.Platform;
import com.example.rdd.Domain.Platform.PlatformRequestDTO;
import com.example.rdd.Domain.Platform.PlatformResponseDTO;
import com.example.rdd.Domain.Subfilter.Subfilter;
import com.example.rdd.Service.PlatformService;
import com.example.rdd.Util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/platform")
public class PlatformController extends GenericController<Platform, Long> {

    @Autowired
    private PlatformService service;

    @PostMapping("/logo")
    public ResponseEntity<PlatformResponseDTO> create(@RequestPart("platform") String platformJson, @RequestPart("logo") MultipartFile logo, @RequestPart("presentationImage") MultipartFile presentationImage, @RequestPart("textTutorial") MultipartFile textTutorial, @RequestPart("subfilters") String subfilters) throws IOException {
        final var requestDTO = PlatformRequestDTO.builder()
                .platform(Util.convertJson(platformJson, Platform.class))
                .logo(logo)
                .presentationImage(presentationImage)
                .textTutorial(textTutorial)
                .subfilters(Util.convertJsonToList(subfilters, Subfilter.class))
                .build();
        final var createdEntity = service.createPlatformWithLogoAndSubfilters(requestDTO);
        return new ResponseEntity<>(createdEntity, HttpStatus.CREATED);
    }

    @GetMapping("dto/{id}")
    public ResponseEntity<PlatformResponseDTO> getPlatformDto(@PathVariable Long id) {
        return new ResponseEntity<>(service.getPlatformDto(id), HttpStatus.OK);
    }

    @GetMapping("dto/list")
    public ResponseEntity<List<PlatformResponseDTO>> getAllPlatformsDto() {
        return new ResponseEntity<>(service.getAllPlatformsDto(), HttpStatus.OK);
    }
}
