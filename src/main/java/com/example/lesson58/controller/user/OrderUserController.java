package com.example.lesson58.controller.user;

import com.example.lesson58.payload.OrderPayload;
import com.example.lesson58.service.impl.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Controller
@RequestMapping("/api/user/order")
@RequiredArgsConstructor
public class OrderUserController {
    private final OrderService orderService;

    @PostMapping("/")
    public ResponseEntity<?> saveOrder(@RequestBody OrderPayload orderPayload){
        return orderService.saveOrder(orderPayload);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        return orderService.getAll();
    }


}
