package com.sq.order.repository;

import com.sq.order.Enums.OrderStatus;
import com.sq.order.Enums.PayStatus;
import com.sq.order.OrderApplicationTests;
import com.sq.order.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderMasterRepositoryTest extends OrderApplicationTests {
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave() {
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("1886131241241");
        orderMaster.setBuyerAddress("慕课网总部");
        orderMaster.setBuyerOpenid("1101110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatus.NEW.getCode());
        orderMaster.setPayStatus(PayStatus.WAIT.getCode());
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result != null);
    }

}