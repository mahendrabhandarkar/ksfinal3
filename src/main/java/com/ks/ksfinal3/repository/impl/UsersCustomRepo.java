package com.ks.ksfinal3.repository.impl;

import com.ks.ksfinal3.entity.Users;

import java.util.List;

public interface UsersCustomRepo {

    public List<Users> findByFirstname(String firstname); 
    
    public List<Users> findByFirstnameResult(String firstname); 
    
}
