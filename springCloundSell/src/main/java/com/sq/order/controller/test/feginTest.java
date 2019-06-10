package com.sq.order.controller.test;


import com.sq.DecreaseStockInput;
import com.sq.ProductInfoOutput;
import com.sq.client.ProductClient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class feginTest {

    @Autowired
    private ProductClient productClient;



    @RequestMapping("/ProductList")
    public String getProductList() {
        List<ProductInfoOutput> response = productClient.listForOrder(Arrays.asList("157875196366160022"));
        log.info(response + "");
        return "ok"+response.get(0);
    }

    @RequestMapping("/productDecreaseStock")
    public String productDecreaseStock() {
        productClient.decreaseStock(Arrays.asList(new DecreaseStockInput("164103465734242707", 3)));
        return "ok";
    }


}
