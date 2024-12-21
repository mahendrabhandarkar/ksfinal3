package com.ks.ksfinal3.repository.cms;

import com.ks.ksfinal3.entity.cms.PageImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Test User
 */
@Repository
public interface PageImageRepository extends JpaRepository<PageImage, Long> {


    public Optional<PageImage> getByIdentity(String identity);

}
