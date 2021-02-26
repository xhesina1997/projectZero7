package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class WishList {

    @EmbeddedId
    private WishListCompositeKey compositeKey;

    @ManyToOne
    @MapsId("productId")
    private Product product;

    @ManyToOne
    @MapsId("userId")
    private UserData userData;

    public WishList(Product product, UserData userData) {
        this.product = product;
        this.userData = userData;
        this.compositeKey = new WishListCompositeKey(product.getId(), userData.getId());
    }

}
