package com.example.lesson58.controller.user;

import com.example.lesson58.model.Result;
import com.example.lesson58.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/user/product")   // ROLE_USER
@RestController
@RequiredArgsConstructor
public class ProductUserController {
    private final ProductServiceImpl productService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "10") int pageSize,
                                    @RequestParam(defaultValue = "0") int pageNo){
        Result result=productService.findAll(pageSize, pageNo);
        return ResponseEntity.status(result.isStatus()?200:409).body(result);
    }


}
