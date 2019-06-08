package com.sq.client.service.Impl;

import com.sq.client.ClientApplicationTests;
import com.sq.client.dto.CartDto;
import com.sq.client.dataobject.ProductInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ProductServiceImplTest extends ClientApplicationTests {
    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        assertEquals(2, list.size());
    }

    @Test
    public void testdecreaseStock() throws Exception {
        CartDto cartDto = new CartDto("157875196366160022", 2);

        productService.decreaseStock(Arrays.asList(cartDto));
    }

}