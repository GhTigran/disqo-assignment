package com.ghmaster.shopapi.api;

import com.ghmaster.shopapi.entity.ProductInfo;
import com.ghmaster.shopapi.service.CategoryService;
import com.ghmaster.shopapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController

@RequestMapping("/products")
public class ProductsController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public Page<ProductInfo> findAll(@RequestParam(value = "search", defaultValue = "") String search,
                                     @RequestParam(value = "category", defaultValue = "0") Integer category,
                                     @RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageRequest request = PageRequest.of(page - 1, size);

        return productService.findAllLike(search, category, request);
    }

    @GetMapping("/{productId}")
    public ProductInfo showOne(@PathVariable("productId") String productId) {
        ProductInfo productInfo = productService.findOne(productId);

        return productInfo;
    }
}
