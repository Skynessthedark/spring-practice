package com.example.demo.services;

import java.util.List;

import com.example.demo.models.ProductDO;
import com.example.demo.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{
    
    @Autowired
    private ProductRepository productRepository;

    public void saveProduct(ProductDO product){
        productRepository.save(product);
    }

    public void deleteProduct(Long productId){
        productRepository.deleteById(productId);
    }

    public ProductDO getProduct(Long productId){
        return  productRepository.findById(productId).get();
    }

    public List<ProductDO> getAllProducts(){
        return productRepository.findAll();
    }
}
