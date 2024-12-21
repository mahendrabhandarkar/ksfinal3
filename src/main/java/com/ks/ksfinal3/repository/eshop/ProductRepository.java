package com.ks.ksfinal3.repository.eshop;

import com.ks.ksfinal3.entity.eshop.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Test User
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public Product getById(Long productId);

}
