package com.example.rdd.Repository;

import com.example.rdd.Domain.Filter.Filter;
import com.example.rdd.Domain.Subfilter.Subfilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubfilterRepository extends JpaRepository<Subfilter, Long> {

    List<Subfilter> findByFilter(Filter filter);
}
