package com.el.app.queue.rabbit.test;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author Danfeng
 * @since 2018/9/23
 */
@Component
@Slf4j
public class Receiver {
    private CountDownLatch latch = new CountDownLatch(10);

    @RabbitListener(queues = {"spring-df"})
    public void receiveMessage(Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        log.debug("FANOUT_QUEUE_B " + new String(message.getBody()));
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
