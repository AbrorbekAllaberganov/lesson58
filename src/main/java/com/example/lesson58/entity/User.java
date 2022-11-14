package com.example.lesson58.entity;

import com.example.lesson58.entity.helper.AbstractHelper;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class User extends AbstractHelper{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long id;

    @Column(unique = true,nullable = false)
    String userName;
    String password;
    String fullName;
    @Column(unique = true,nullable = false)
    String phoneNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Role> roleList;  // ROLE_ADMIN ROLE_USER

//    @CreationTimestamp
//    Date createAt;
//
//
//    @UpdateTimestamp
//    Date updateAt;
}
