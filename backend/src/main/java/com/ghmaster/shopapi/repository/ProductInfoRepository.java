package com.ghmaster.shopapi.repository;

import com.ghmaster.shopapi.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductInfoRepository extends CrudRepository<ProductInfo, String> {
    // onsale product
    Page<ProductInfo> findAllByStatusOrderByIdAsc(Integer status, Pageable pageable);

    // product in one category
    Page<ProductInfo> findAllByCategoryIdOrderByIdAsc(Integer categoryId, Pageable pageable);

    Page<ProductInfo> findAllByOrderById(Pageable pageable);

    @Query("SELECT p FROM ProductInfo p WHERE (:name = '' OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND (:cat = 0 OR :cat = p.categoryId) ORDER BY p.id ASC")
    Page<ProductInfo> findAllByNameContainingIgnoreCaseAndCategoryIdOrderById(@Param("name")String name, @Param("cat")Integer categpryId, Pageable pageable);

}
