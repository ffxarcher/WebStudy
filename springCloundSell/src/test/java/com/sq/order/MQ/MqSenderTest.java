package com.sq.order.MQ;

import com.sq.order.OrderApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

public class MqSenderTest extends OrderApplicationTests {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public  void send()
    {
        amqpTemplate.convertAndSend("myExchange","computer","computer"+new Date());
    }
}
