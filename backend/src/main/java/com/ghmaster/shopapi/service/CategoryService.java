package com.ghmaster.shopapi.service;

import com.ghmaster.shopapi.entity.ProductCategory;

import java.util.List;

public interface CategoryService {

    List<ProductCategory> findAll();

    ProductCategory findByCategoryId(Integer categoryType);

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);


}
