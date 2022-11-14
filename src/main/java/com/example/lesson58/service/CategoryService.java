package com.example.lesson58.service;

import com.example.lesson58.entity.Category;
import com.example.lesson58.model.Result;
import com.example.lesson58.payload.CategoryPayload;

public interface CategoryService {
    Result add(CategoryPayload categoryPayload);
    Result delete(Long id);
    Result edit(CategoryPayload categoryPayload,Long id);
    Result findAll();

    Category findById(Long id);
}
