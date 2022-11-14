package com.example.lesson58.service.impl;

import com.example.lesson58.entity.Order;
import com.example.lesson58.entity.helper.OrderStatus;
import com.example.lesson58.model.Result;
import com.example.lesson58.payload.OrderPayload;
import com.example.lesson58.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductCountService productCountService;
    private final Result result;

    public ResponseEntity<?> saveOrder(OrderPayload orderPayload) {
        try {
            Order order = new Order();
            order.setOrderStatus(OrderStatus.ACTIVE);
            order.setComment(orderPayload.getComment());
            order.setProductCounts(productCountService.saveProductCount(orderPayload.getProductCountPayloads()));

            orderRepository.save(order);
            return ResponseEntity.status(200).body(result.success(order));
        } catch (Exception e) {
            return ResponseEntity.status(409).body(result.failed(e.getMessage()));
        }
    }

    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(orderRepository.findAll());
    }
}
