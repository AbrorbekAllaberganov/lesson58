package com.example.lesson58.service.impl;

import com.example.lesson58.entity.ProductCount;
import com.example.lesson58.payload.ProductCountPayload;
import com.example.lesson58.repository.ProductCountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductCountService {
//    @Autowired
    private final ProductCountRepository productCountRepository;
    private final ProductServiceImpl productService;

    public List<ProductCount> saveProductCount(List<ProductCountPayload> productCountPayloads){
        List<ProductCount> productCounts=
                productCountPayloads.stream()
                        .map(productCountPayload ->
                                new ProductCount(productService.getById(productCountPayload.getProductId()),productCountPayload.getCount()))
                        .collect(Collectors.toList());
        productCountRepository.saveAll(productCounts);


        return productCounts;
    }

}
