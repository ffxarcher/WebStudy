package com.sq.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;


@EnableBinding(StreamClient.class)
@Component
@Slf4j
public class StreamReceiver {

    @StreamListener(value = StreamClient.INPUT)
    public void process(Object message)
    {
        log.info("message"+message);

    }

    @StreamListener(StreamClient.OUTPUT)
    public void processOutput(Object message)
    {
       // log.info("output"+message);
    }
}
