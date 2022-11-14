package com.example.lesson58.payload;

import lombok.Data;

@Data
public class ProductPayload {
    String name;

    String hashId;
    Long categoryId;

    String description;

    Double price;
}
