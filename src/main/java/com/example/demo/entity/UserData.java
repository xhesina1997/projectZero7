package com.example.demo.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
@Getter
@Setter
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    private Long id;

//    @Column(nullable = false)
    private String username;

//    @Column(nullable = false)
    private String name;

//    @Column(nullable = false)
    private String address;

//    @Column(nullable = false)
    private String password;

//    @Column(name = "created_at")
//    @CreationTimestamp
//    private LocalDateTime createdAt;
//
//    @Column(name = "updated_at")
//    @UpdateTimestamp
//    private LocalDateTime updatedAt;

    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "userID", referencedColumnName = "id")
    private List<Product> products;




}
