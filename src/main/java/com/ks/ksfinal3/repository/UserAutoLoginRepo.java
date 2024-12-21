package com.ks.ksfinal3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ks.ksfinal3.entity.UserAutoLogin;

//@ComponentScan(basePackages = {"com.uc.controller", "com.uc.service", "com.uc.repository", "com.uc.model"})
@Repository 
public interface UserAutoLoginRepo extends JpaRepository<UserAutoLogin, Integer> 
{

}
