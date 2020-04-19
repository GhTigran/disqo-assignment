package com.ghmaster.shopapi.service.impl;


import com.ghmaster.shopapi.entity.ProductCategory;
import com.ghmaster.shopapi.enums.ResultEnum;
import com.ghmaster.shopapi.exception.MyException;
import com.ghmaster.shopapi.repository.ProductCategoryRepository;
import com.ghmaster.shopapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    ProductCategoryRepository productCategoryRepository;


    @Override
    public List<ProductCategory> findAll() {
        List<ProductCategory> res = productCategoryRepository.findAllByOrderById();
        return res;
    }

    @Override
    public ProductCategory findByCategoryId(Integer categoryId) {
        ProductCategory res = productCategoryRepository.findById(categoryId).orElse(null);
        if (res == null) throw new MyException(ResultEnum.CATEGORY_NOT_FOUND);
        return res;
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        List<ProductCategory> res = productCategoryRepository.findByIdInOrderByIdAsc(categoryTypeList);
        return res;
    }

    @Override
    @Transactional
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }


}
