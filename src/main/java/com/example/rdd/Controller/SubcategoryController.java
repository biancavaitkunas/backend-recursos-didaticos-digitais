package com.example.rdd.Controller;

import com.example.rdd.Controller.Generic.GenericController;
import com.example.rdd.Domain.Subcategory.Subcategory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subcategory")
public class SubcategoryController extends GenericController<Subcategory, Long> {
}
