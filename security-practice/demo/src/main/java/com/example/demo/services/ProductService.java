package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.ProductDO;
import com.example.demo.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public ProductDO createProduct(ProductDO product){
        return productRepository.save(product);
    }

    public ProductDO updateProduct(ProductDO product){
        Optional<ProductDO> currProduct = productRepository.findById(product.getId());
        if(currProduct.isPresent()){
            currProduct.get().setName(product.getName());
            currProduct.get().setBrand(product.getBrand());
            currProduct.get().setMadeIn(product.getMadeIn());
            currProduct.get().setPrice(product.getPrice());

            return productRepository.save(currProduct.get());
        }
        return null;
    }

    public void deleteProduct(Long productId){
        productRepository.deleteById(productId);
    }

    public ProductDO getProduct(Long productId){
        Optional<ProductDO> product = productRepository.findById(productId);
        if(product.isPresent()) return product.get();
        return null;
    }

    public List<ProductDO> getAllProducts(){
        return productRepository.findAll();
    }
}
