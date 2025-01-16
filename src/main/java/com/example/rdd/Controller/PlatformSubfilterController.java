package com.example.rdd.Controller;

import com.example.rdd.Domain.PlatformSubfilter.PlatformSubfilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/platform_subfilter")
public class PlatformSubfilterController extends GenericController<PlatformSubfilter, Long> {
}
