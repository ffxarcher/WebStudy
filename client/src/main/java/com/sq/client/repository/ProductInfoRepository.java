package com.sq.client.repository;


import com.sq.client.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    List<ProductInfo> findAllByProductStatus(Integer productStaus);

    List<ProductInfo> findByProductIdIn(List<String> productId);
}
