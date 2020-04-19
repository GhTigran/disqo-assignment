package com.ghmaster.shopapi.api;


import com.ghmaster.shopapi.entity.ProductCategory;
import com.ghmaster.shopapi.service.CategoryService;
import com.ghmaster.shopapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoriesController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;


    /**
     * Get all categories
     *
     * @return List<ProductCategory>
     */
    @GetMapping("/")
    public List<ProductCategory> getAllCategories() {

        List<ProductCategory> categories = categoryService.findAll();
        return categories;
    }
}
