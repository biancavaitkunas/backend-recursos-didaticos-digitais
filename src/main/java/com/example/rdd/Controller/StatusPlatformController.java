package com.example.rdd.Controller;

import com.example.rdd.Domain.StatusPlatform.StatusPlatform;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status_platform")
public class StatusPlatformController extends GenericController<StatusPlatform, Long> {
}
