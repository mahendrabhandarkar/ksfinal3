package com.ks.ksfinal3.entity.eshop;

import lombok.Data;

import jakarta.persistence.*;

/**
 * @author Test User
 */
@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Double price;

    @Column
    private String title;

}
