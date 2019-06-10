package com.sq.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


public interface StreamClient {
    /**
     * 新版中两个通道的名称不能相同，若需要消息的自我消费
     * 需要将两个通道绑定到同一topic下
     */
     String INPUT  = "topic-input";
     String OUTPUT  = "topic-output";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();

}
