package com.sq.client.repository;

import com.sq.client.ClientApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductInfoRepositoryTest extends ClientApplicationTests {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void productIdFind() {
        List<String> productIdList = new ArrayList<>();
        productIdList.add("157875196366160022");
        System.out.println(productInfoRepository.findByProductIdIn(productIdList));
    }

}