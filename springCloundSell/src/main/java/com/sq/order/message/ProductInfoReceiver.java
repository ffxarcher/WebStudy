package com.sq.order.message;

import com.sq.ProductInfoOutput;
import com.sq.order.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductInfoReceiver {
    @RabbitListener(queuesToDeclare = @Queue("productInfo"))

    public void process(String message)
    {
        ProductInfoOutput productInfoOutput =
                (ProductInfoOutput) JsonUtil.fromJson(message,ProductInfoOutput.class);
        log.info("从队列中获取消息"+productInfoOutput);
    }
}
