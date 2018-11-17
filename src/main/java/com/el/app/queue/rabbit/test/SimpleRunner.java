package com.el.app.queue.rabbit.test;

import com.el.app.queue.rabbit.config.RabbitMqConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Danfeng
 * @since 2018/9/23
 */

@Slf4j
@Component
@Order(1)
@AllArgsConstructor
public class SimpleRunner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final SimpleReceiver simpleReceiver;
    private final SimpleReceiver2 simpleReceiver2;

    @Override
    public void run(String... args) throws Exception {
        log.info("Sending message...");
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitMqConfig.topicExchangeName, "foo.bar.#", "Hello from RabbitMQ!", correlationData);
        simpleReceiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        simpleReceiver2.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }
}
