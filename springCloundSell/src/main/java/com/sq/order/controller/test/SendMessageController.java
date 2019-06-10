package com.sq.order.controller.test;

import com.sq.order.dto.OrderDto;
import com.sq.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SendMessageController {
    @Autowired
    private StreamClient streamClient;

    OrderDto orderDto = new OrderDto();

    @GetMapping("/message")
    public void sendMessage()
    {
        orderDto.setOrderId("12345");
        //streamClient.output().send(MessageBuilder.withPayload("hello"+new Date()).build());//发送消息
        streamClient.output().send(MessageBuilder.withPayload(orderDto).build());
    }
}
