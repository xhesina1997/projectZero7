package com.example.demo.controller;

import com.example.demo.domainModel.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method= RequestMethod.GET)
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @RequestMapping(value="/productId/{productId}",method=RequestMethod.GET)
    public ProductDTO getProductById(Long productId){
        return productService.getProductById(productId);
    }


    @RequestMapping(method=RequestMethod.POST)
    public String createProduct(@RequestBody Product product){
       return productService.createProduct(product);
    }

    @RequestMapping(value = "/delete/{productId}",method=RequestMethod.DELETE)
    public String deleteProduct(Long productId){
        return productService.deleteProduct(productId);
    }

}
