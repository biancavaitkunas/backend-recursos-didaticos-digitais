package com.example.rdd.Service.impl;

import com.example.rdd.Domain.Filter.Filter;
import com.example.rdd.Domain.Subfilter.Subfilter;
import com.example.rdd.Repository.SubfilterRepository;
import com.example.rdd.Service.SubfilterService;
import com.example.rdd.Service.exceptions.ObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SubfilterServiceImpl extends SubfilterService {

    @Autowired
    SubfilterRepository repository;

    public List<Subfilter> findByFilter(final Filter filter) {
        if (repository.findByFilter(filter).isEmpty()) {
            throw new ObjectNotFound("Object Not Found");
        }
        return repository.findByFilter(filter);
    };
}
