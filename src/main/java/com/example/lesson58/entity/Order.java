package com.example.lesson58.entity;

import com.example.lesson58.entity.helper.AbstractHelper;

import com.example.lesson58.entity.helper.OrderStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name="orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    User user;

//    @OneToOne
//    Product product;
//
//    int count;

    @OneToMany(fetch = FetchType.LAZY)
    List<ProductCount> productCounts;

    String comment;

    @Enumerated(EnumType.ORDINAL)
    OrderStatus orderStatus;  //  DONE=0 ACTIVE=1


}
