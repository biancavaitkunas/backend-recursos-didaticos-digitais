package com.example.rdd.Controller;

import com.example.rdd.Domain.Filter.Filter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filter")
public class FilterController extends GenericController<Filter, Long> {
}
