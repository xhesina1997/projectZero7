package com.example.demo.controller;

import com.example.demo.domainModel.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.UserData;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final UserService userService;
    @Autowired
    public ProductController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping(value = "/pageNr/{pageNr}/pageSize/{pageSize}")
    public Page<Product> getAllProducts(@PathVariable int pageNr, @PathVariable int pageSize){
        return productService.getAllProducts(pageNr,pageSize);
    }

    @GetMapping()
    public List<Product> getAllProductsNotPaged(){
        return productService.getAllProductsNotPaged();
    }
    @RequestMapping(value="/orderedByCreatedDate",method= RequestMethod.GET)
    public List<ProductDTO> getAllProductsOrderedByCreatedDate(){
        return productService.orderByCreatedDate();
    }
    @RequestMapping(value="/productId/{productId}",method=RequestMethod.GET)
    public ProductDTO getProductById(@PathVariable Long productId){
        return productService.getProductById(productId);
    }


    @RequestMapping(method=RequestMethod.POST)
    public void createProduct(@RequestBody Product product){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Long userId = userService.getUserByUsername(userDetails.getUsername()).get().getId();
        UserData userData = new UserData();
        userData.setId(userId);
        product.setUserID(userId);
        productService.createProduct(product);

    }

    @RequestMapping(value = "/delete/{productId}",method=RequestMethod.DELETE)
    public String deleteProduct(Long productId){
        return productService.deleteProduct(productId);
    }

}
