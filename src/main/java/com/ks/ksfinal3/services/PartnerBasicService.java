package com.ks.ksfinal3.services;

import com.ks.ksfinal3.projection.PartnersBasicCountryNameProjection;
import com.ks.ksfinal3.projection.PartnersBasicUsersIdProjection;

import java.util.List;

public interface PartnerBasicService {

    public PartnersBasicUsersIdProjection fetchUsersId();

    public PartnersBasicCountryNameProjection fetchPcountry();
}
