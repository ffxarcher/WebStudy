package com.sq.client.dto;

import lombok.Data;

@Data
public class CartDto {
    //商品名称
    private String productId;
    //商品数量
    private Integer productQuantity;

    public CartDto() {

    }

    public CartDto(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
