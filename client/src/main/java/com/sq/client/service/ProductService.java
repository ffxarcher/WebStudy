package com.sq.client.service;

import com.sq.client.dto.CartDto;
import com.sq.client.dataobject.ProductInfo;

import java.util.List;

public interface ProductService {
    List<ProductInfo> findUpAll();

    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     *
     * @param cartDtoList
     */
    void decreaseStock(List<CartDto> cartDtoList);
}
