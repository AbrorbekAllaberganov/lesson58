package com.example.lesson58.entity;

import com.example.lesson58.entity.helper.AbstractHelper;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Category extends AbstractHelper {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long id;

    String name;

//    @CreationTimestamp
//    Date createdAt;
//
//    @UpdateTimestamp
//    Date updatedAt;

}
