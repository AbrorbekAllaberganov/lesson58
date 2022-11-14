package com.example.lesson58.service.impl;

import com.example.lesson58.entity.Category;
import com.example.lesson58.exeption.ResourceNotFound;
import com.example.lesson58.model.Result;
import com.example.lesson58.payload.CategoryPayload;
import com.example.lesson58.repository.CategoryRepository;
import com.example.lesson58.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final Result result;

    @Override
    public Result add(CategoryPayload categoryPayload) {
        try {
            Category category = new Category();
            category.setName(categoryPayload.getName());
            categoryRepository.save(category);
            return result.success(category);
        } catch (Exception e) {
            log.error(e.getMessage());
            return result.failed(e.getMessage());
        }

    }

    @Override
    public Result delete(Long id) {
        return null;
    }

    @Override
    public Result edit(CategoryPayload categoryPayload, Long id) {
        return null;
    }

    @Override
    public Result findAll() {
        return null;
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()->new ResourceNotFound("category","id",id));
    }
}
