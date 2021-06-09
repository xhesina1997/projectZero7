package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long>{
    List<Product> findByOrderByTitleAsc();
    List<Product> findByOrderByTitleDesc();
    List<Product> findByOrderByCreatedAtDesc();
    List<Product> findByOrderByCreatedAtAsc();
    List<Product> findByCategoryId(Long categoryId);

}
