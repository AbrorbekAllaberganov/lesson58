package com.example.lesson58.controller.admin;

import com.example.lesson58.model.Result;
import com.example.lesson58.payload.ProductPayload;
import com.example.lesson58.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/product")
@RequiredArgsConstructor
public class ProductAdminController {
    private final ProductServiceImpl productService;

    @PostMapping("/save")
    public ResponseEntity<?>saveProduct(@RequestBody ProductPayload productPayload){
        Result result=productService.add(productPayload);
        return ResponseEntity.status(result.isStatus()?200:409).body(result);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<?>editProduct(@RequestBody ProductPayload productPayload,
                                        @PathVariable Long id){
        Result result=productService.edit(productPayload,id);
        return ResponseEntity.status(result.isStatus()?200:409).body(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteProduct(@PathVariable Long id){
        Result result=productService.delete(id);
        return ResponseEntity.status(result.isStatus()?200:409).body(result);
    }
}
