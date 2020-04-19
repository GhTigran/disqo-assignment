package com.ghmaster.shopapi.repository;

import com.ghmaster.shopapi.entity.ProductCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer> {
    // Some category
    List<ProductCategory> findByIdInOrderByIdAsc(List<Integer> categoryTypes);

    // All category
    List<ProductCategory> findAllByOrderById();
}
