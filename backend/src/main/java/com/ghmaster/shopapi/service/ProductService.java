package com.ghmaster.shopapi.service;


import com.ghmaster.shopapi.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    ProductInfo findOne(String productId);

    // All selling products
    Page<ProductInfo> findUpAll(Pageable pageable);

    // All products
    Page<ProductInfo> findAll(Pageable pageable);

    // All products
    Page<ProductInfo> findAllLike(String search, Integer categoryType, Pageable pageable);

    // All products in a category
    Page<ProductInfo> findAllInCategory(Integer categoryType, Pageable pageable);
}
