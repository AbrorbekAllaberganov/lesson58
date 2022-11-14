package com.example.lesson58.entity;


import com.example.lesson58.entity.helper.AbstractHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCount  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    Product product;

    @Column(columnDefinition = "default ")
    int count=10;

    public ProductCount(Product product, int count) {
        this.product = product;
        this.count = count;
    }
}
