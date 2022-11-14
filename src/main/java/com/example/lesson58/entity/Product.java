package com.example.lesson58.entity;

import com.example.lesson58.entity.helper.AbstractHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Product extends AbstractHelper {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long id;

    String name;

    String description;

    Double price;

    @ManyToOne
    Category category; // Long id

    @OneToOne
    Attachment image;  // String hashId

    @CreatedBy
    @OneToOne
    User createdBy;  // create

    @LastModifiedBy
    @OneToOne
    User updatedBy; // update

//    @CreationTimestamp
//    Date createdAt;
//
//    @UpdateTimestamp
//    Date updatedAt;

}
