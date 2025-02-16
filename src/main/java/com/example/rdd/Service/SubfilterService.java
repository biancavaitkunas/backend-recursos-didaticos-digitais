package com.example.rdd.Service;

import com.example.rdd.Domain.Filter.Filter;
import com.example.rdd.Domain.Subfilter.Subfilter;
import com.example.rdd.Repository.SubfilterRepository;
import com.example.rdd.Service.Generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubfilterService extends GenericService<Subfilter, Long> {

    @Autowired
    SubfilterRepository subfilterRepository;

    public List<Subfilter> findByFilter(Filter filter) {
        return subfilterRepository.findByFilter(filter);
    }

}
