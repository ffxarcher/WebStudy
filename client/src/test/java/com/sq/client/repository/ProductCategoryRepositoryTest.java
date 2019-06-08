package com.sq.client.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void test() {
        productCategoryRepository.findByCategoryTypeIn(Arrays.asList(11, 22));
    }
}