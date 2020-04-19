package com.ghmaster.shopapi.service.impl;


import com.ghmaster.shopapi.entity.ProductInfo;
import com.ghmaster.shopapi.enums.ProductStatusEnum;
import com.ghmaster.shopapi.repository.ProductInfoRepository;
import com.ghmaster.shopapi.service.CategoryService;
import com.ghmaster.shopapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @Autowired
    CategoryService categoryService;

    @Override
    public ProductInfo findOne(String productId) {
        ProductInfo productInfo = productInfoRepository.findById(productId).orElse(null);
        return productInfo;
    }

    @Override
    public Page<ProductInfo> findUpAll(Pageable pageable) {
        return productInfoRepository.findAllByStatusOrderByIdAsc(ProductStatusEnum.UP.getCode(), pageable);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAllByOrderById(pageable);
    }

    @Override
    public Page<ProductInfo> findAllLike(String search, Integer categoryType, Pageable pageable) {
        return productInfoRepository.findAllByNameContainingIgnoreCaseAndCategoryIdOrderById(search, categoryType, pageable);
    }

    @Override
    public Page<ProductInfo> findAllInCategory(Integer categoryType, Pageable pageable) {
        return productInfoRepository.findAllByCategoryIdOrderByIdAsc(categoryType, pageable);
    }
}
