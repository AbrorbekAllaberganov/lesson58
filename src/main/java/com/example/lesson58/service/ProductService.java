package com.example.lesson58.service;

import com.example.lesson58.model.Result;
import com.example.lesson58.payload.ProductPayload;

public interface ProductService {
    Result add(ProductPayload productPayload);
    Result delete(Long id);
    Result edit(ProductPayload productPayload,Long id);
    Result findById(Long id);
    Result findAll(int pageSize,int pageNo);
}
