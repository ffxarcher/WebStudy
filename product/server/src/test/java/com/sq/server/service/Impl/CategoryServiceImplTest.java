package com.sq.server.service.Impl;

import com.sq.server.ServerApplicationTests;
import com.sq.server.service.CategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CategoryServiceImplTest extends ServerApplicationTests {

    @Autowired
    private CategoryService categoryService;
    @Test
    public void findByCategoryTypeIn() {

        System.out.println(categoryService.findByCategoryTypeIn(Arrays.asList(0)).size());
    }
}