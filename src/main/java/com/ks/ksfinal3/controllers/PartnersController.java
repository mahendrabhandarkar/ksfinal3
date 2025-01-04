package com.ks.ksfinal3.controllers;

import com.ks.ksfinal3.projection.PartnersBasicCountryNameProjection;
import com.ks.ksfinal3.projection.PartnersBasicUsersIdProjection;
import com.ks.ksfinal3.services.PartnerBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apis/partners")
public class PartnersController {
    @Autowired
    private PartnerBasicService partnerBasicService;

    @GetMapping("/list")
    public PartnersBasicUsersIdProjection getAllUserIds() {
        return partnerBasicService.fetchUsersId();
    }

    @GetMapping("/country")
    public PartnersBasicCountryNameProjection fetchPcountry() {
        return partnerBasicService.fetchPcountry();
    }
}
