package com.example.lesson58.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderPayload {
    String comment;
    List<ProductCountPayload> productCountPayloads;
    Long userId;
}
