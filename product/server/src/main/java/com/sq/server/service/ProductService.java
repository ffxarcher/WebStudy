package com.sq.server.service;


import com.sq.DecreaseStockInput;
import com.sq.server.dataobject.ProductInfo;


import java.util.List;

public interface ProductService {
    List<ProductInfo> findUpAll();

    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     *
     * @param cartDtoList
     */
    void decreaseStock(List<DecreaseStockInput> cartDtoList);
}
