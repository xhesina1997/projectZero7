package com.example.demo.domainModel;

import com.example.demo.entity.Product;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProductDTO {

    private Long id;

    private String title;

    private Double price;

    private String brand;

    private String size;

    private String productColor;

    private String description;

    private Long userID;

    private LocalDateTime updatedAt;

    private LocalDateTime createdAt;

    public static ProductDTO toDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setBrand(product.getBrand());
        productDTO.setProductColor(product.getProductColor());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());
        productDTO.setTitle(product.getTitle());
        productDTO.setSize(product.getSize());
        productDTO.setCreatedAt(product.getCreatedAt());
        productDTO.setUpdatedAt(product.getUpdatedAt());
        productDTO.setUserID(product.getUserID());
        return productDTO;
    }
    public static List<ProductDTO> toDTOs(List<Product> products){
        return products.stream().map(ProductDTO::toDTO).collect(Collectors.toList());
    }
}
