package com.sq.sever.repository;

import com.sq.sever.SeverApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 牢记测试方法，命名要规范啊
 *
 */
public class myTest extends SeverApplicationTests {

    @Autowired
    private UserInfoRepository repository;

    @Test
    public void mTest()
    {
        System.out.println(repository.findByOpenid("huahua").getUsername());
    }
}
