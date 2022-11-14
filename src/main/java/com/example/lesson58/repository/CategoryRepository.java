package com.example.lesson58.repository;

import com.example.lesson58.entity.Category;
import com.sun.org.apache.xml.internal.resolver.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
