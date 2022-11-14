package com.example.lesson58.repository;

import com.example.lesson58.entity.Product;
import com.example.lesson58.model.ProductModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
//    jpql
    @Query("select new com.example.lesson58.model.ProductModel(p.name,p.description,p.price,p.category.id,p.image.hashId) from Product p")
    ProductModel getAll();
}
