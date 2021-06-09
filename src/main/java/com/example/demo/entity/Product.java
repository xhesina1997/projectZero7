package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    private Long id;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private String productColor;

    @Column(nullable = false)
    private String description;

    @Column
    private Long userID;
    @Column
    private Long categoryId;
}
