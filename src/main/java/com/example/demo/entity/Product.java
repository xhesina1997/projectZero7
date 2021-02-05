package com.example.demo.entity;

import lombok.Data;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    private Long id;

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


}
