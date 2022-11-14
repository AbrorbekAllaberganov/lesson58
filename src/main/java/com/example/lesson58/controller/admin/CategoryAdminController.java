package com.example.lesson58.controller.admin;

import com.example.lesson58.model.Result;
import com.example.lesson58.payload.CategoryPayload;
import com.example.lesson58.payload.ProductPayload;
import com.example.lesson58.service.impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/category")
@RequiredArgsConstructor
public class CategoryAdminController {
    private final CategoryServiceImpl categoryService;

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody CategoryPayload categoryPayload){
        Result result=categoryService.add(categoryPayload);
        return ResponseEntity.status(result.isStatus()?200:409).body(result);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<?>editProduct(@RequestBody CategoryPayload categoryPayload,
                                        @PathVariable Long id){
        Result result=categoryService.edit(categoryPayload,id);
        return ResponseEntity.status(result.isStatus()?200:409).body(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteProduct(@PathVariable Long id){
        Result result=categoryService.delete(id);
        return ResponseEntity.status(result.isStatus()?200:409).body(result);
    }

}
