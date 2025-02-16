package com.example.rdd.Controller;

import com.example.rdd.Controller.Generic.GenericController;
import com.example.rdd.Domain.Platform.Platform;
import com.example.rdd.Domain.PlatformSubfilter.PlatformSubfilter;
import com.example.rdd.Domain.Subfilter.Subfilter;
import com.example.rdd.Service.PlatformSubfilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/platform_subfilter")
public class PlatformSubfilterController extends GenericController<PlatformSubfilter, Long> {

    @Autowired
    private PlatformSubfilterService service;

    @GetMapping("dto/{id}")
    public ResponseEntity<List<Subfilter>> getPlatformDto(@PathVariable Platform platform) {
        return new ResponseEntity<>(service.getSubfiltersByPlatform(platform), HttpStatus.OK);
    }
}
