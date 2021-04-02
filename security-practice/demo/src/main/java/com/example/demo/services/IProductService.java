package com.example.demo.services;

import java.util.List;

import com.example.demo.models.ProductDO;

public interface IProductService {
    
    void saveProduct(ProductDO product);
    void deleteProduct(Long productId);
    ProductDO getProduct(Long productId);
    List<ProductDO> getAllProducts();
}
