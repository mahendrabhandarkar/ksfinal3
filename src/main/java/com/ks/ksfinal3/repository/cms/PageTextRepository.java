package com.ks.ksfinal3.repository.cms;

import com.ks.ksfinal3.entity.cms.PageText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Test User
 */
@Repository
public interface PageTextRepository extends JpaRepository<PageText, Long> {

    public Optional<PageText> findByIdentity(String identity);

}
