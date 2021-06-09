package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    private Long id;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "name")
    private String name;

    @Column(name="parent_id")
    private Long parentId;
//    @OneToOne
//    @JoinColumn(name = "parent_id", referencedColumnName = "id")
//    private Category category;
//
//    @OneToMany
//    @JoinColumn(name="category_id",referencedColumnName = "id")
//    private List<Product> products;
}
