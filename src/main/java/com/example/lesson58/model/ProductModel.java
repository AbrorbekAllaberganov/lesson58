package com.example.lesson58.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductModel {
    String name;
    String description;
    Double price;
    Long categoryId;
    String hashId;


    public ProductModel(String name, String description, Double price, Long categoryId, String hashId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.hashId = hashId;
    }

    public ProductModel(String name, String description, Double price, Long categoryId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
    }
}
