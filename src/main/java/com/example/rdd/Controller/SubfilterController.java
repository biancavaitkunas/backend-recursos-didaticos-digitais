package com.example.rdd.Controller;

import com.example.rdd.Domain.Subfilter.Subfilter;
import com.example.rdd.Service.FilterService;
import com.example.rdd.Service.SubfilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subfilter")
public class SubfilterController extends GenericController<Subfilter, Long> {

    @Autowired
    private SubfilterService service;

    @Autowired
    private FilterService filterService;

    @GetMapping("filter/{filterId}")
    public ResponseEntity<List<Subfilter>> findByFilter(@PathVariable Long filterId) {
        return ResponseEntity.ok(service.findByFilter(filterService.findById(filterId).orElseThrow()));
    }
}
