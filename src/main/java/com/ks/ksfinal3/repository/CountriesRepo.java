package com.ks.ksfinal3.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ks.ksfinal3.entity.Countries;

//@ComponentScan(basePackages = {"com.uc.controller", "com.uc.service", "com.uc.repository", "com.uc.model"})
@Repository 
public interface CountriesRepo extends PagingAndSortingRepository<Countries, Integer>
{

    Page<Countries> findByNameContaining(String searchValue, Pageable pageable);

    Iterable<Countries> findByNameContaining(String searchValue, Sort sort);
}
