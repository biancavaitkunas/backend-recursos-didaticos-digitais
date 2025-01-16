package com.example.rdd.Controller;

import com.example.rdd.Domain.Ocupation.Ocupation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ocupation")
public class OcupationController extends GenericController<Ocupation, Long> {
}
