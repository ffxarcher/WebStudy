/*
package com.sq.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MqReceiver {
*/
/**
 * 需要手动创建队列
    @RabbitListener(queues = "MyQueue")
    public void process(String msg)
    {
        log.info("MyQueue: {}",msg);
    }
    *//*


    */
/**
     * 自动创建所需队列
     * @param msg
     *//*

//    @RabbitListener(queuesToDeclare = @Queue("MyQueue"))


    */
/**
     * 添加Exchanges将对应queue与Exchanges绑定
     *
     * exchage交换机的routing key
     * value队列名，若没有则创建
     * key  binding key绑定exchange和queue
     * @param msg
     *//*

    @RabbitListener(bindings =  @QueueBinding(
            value = @Queue("computerOrder"),
            key = "computer",
            exchange = @Exchange("myExchange")
    ))
    public void process(String msg)
    {
        log.info(" computerOrder: {}",msg);
    }

    @RabbitListener(bindings =  @QueueBinding(
            value = @Queue("fruitOrder"),
            key = "fruit",
            exchange = @Exchange("myExchange")
    ))
    public void fruitProcess(String msg)
    {
        log.info(" fruitOrder: {}",msg);
    }


}
*/
