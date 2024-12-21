package com.ks.ksfinal3.repository.auth;

import com.ks.ksfinal3.entity.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Test User
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
