package com.ks.ksfinal3.services.impl;

import com.ks.ksfinal3.projection.PartnersBasicCountryNameProjection;
import com.ks.ksfinal3.projection.PartnersBasicUsersIdProjection;
import com.ks.ksfinal3.repository.PartnerBasicRepo;
import com.ks.ksfinal3.services.PartnerBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerBasicServiceImpl implements PartnerBasicService {

    @Autowired
    private PartnerBasicRepo partnerBasicRepo;

    public PartnersBasicUsersIdProjection fetchUsersId() {
        return partnerBasicRepo.findAllProjectedBy(PartnersBasicUsersIdProjection.class);
    }

    public PartnersBasicCountryNameProjection fetchPcountry() {
        return partnerBasicRepo.findAllProjectedBy(PartnersBasicCountryNameProjection.class);
    }
}
