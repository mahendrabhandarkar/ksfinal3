package com.ks.ksfinal3.repository;

import com.ks.ksfinal3.projection.PartnersBasicCountryNameProjection;
import com.ks.ksfinal3.projection.PartnersBasicUsersIdProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ks.ksfinal3.entity.PartnerBasic;

import java.util.Collection;
import java.util.List;

//@ComponentScan(basePackages = {"com.uc.controller", "com.uc.service", "com.uc.repository", "com.uc.model"})
@Repository 
public interface PartnerBasicRepo extends JpaRepository<PartnerBasic, Integer> 
{
    // We can use basic projections to select a subset of fields from a single entity,
    // nested projections to select a subset of fields from related entities,
    // and dynamic projections to select a subset of fields based on runtime conditions.
  //  <T> Collection<T> findByParameter(Object name, Class<T> type);
    <T> T findAllProjectedBy(Class<T> type);
//    PartnersBasicUsersIdProjection findAllProjectedBy();

//    PartnersBasicCountryNameProjection fetchPcountry();

}
