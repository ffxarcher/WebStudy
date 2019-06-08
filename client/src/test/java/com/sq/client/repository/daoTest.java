package com.sq.client.repository;

import com.sq.client.ClientApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class daoTest extends ClientApplicationTests {
    @Autowired
    private ProductInfoRepository mdao;

    @Test
    public void test() {
        System.out.println(mdao.findAllByProductStatus(1));
    }

}