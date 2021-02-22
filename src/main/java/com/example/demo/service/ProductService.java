package com.example.demo.service;

import com.example.demo.domainModel.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> getAllProducts(int pageNr, int pageSize){
        Pageable pageable = PageRequest.of(pageNr-1,pageSize);
        return productRepository.findAll(pageable);

    }

    public List<Product> getAllProductsNotPaged(){
        return productRepository.findAll();
    }
    public ProductDTO getProductById(Long productId){
        Optional<Product> product = productRepository.findById(productId);
        return product.map(ProductDTO::toDTO).orElse(null);

    }

    public String createProduct(Product product){
        productRepository.save(product);
        return "Product created successfully";
    }

    public String deleteProduct(Long productId){
        Optional<Product> product = productRepository.findById(productId);
        productRepository.delete(product.get());
        return "Product deleted successfully!";
    }

    public List<ProductDTO> orderByCreatedDate(){
        List<Product> products =  productRepository.findByOrderByCreatedAtDesc();
        return ProductDTO.toDTOs(products);
    }
}
