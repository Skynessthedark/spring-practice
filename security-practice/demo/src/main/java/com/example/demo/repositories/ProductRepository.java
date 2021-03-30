package com.example.demo.repositories;

import com.example.demo.models.ProductDO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDO, Long>{
        
}
