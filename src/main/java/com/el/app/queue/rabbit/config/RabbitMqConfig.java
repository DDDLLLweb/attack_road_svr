package com.el.app.queue.rabbit.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Danfeng
 * @since 2018/9/23
 */
@Slf4j
@Configuration
@AutoConfigureAfter(RabbitAutoConfiguration.class)
public class RabbitMqConfig {


    public static final String topicExchangeName = "spring-df-exchange";

    static final String queueName = "spring-df";

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMqConfig(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
    }

    @Bean
    public Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

//    @Bean
//    public AmqpTemplate amqpTemplate() {
//        // 使用jackson 消息转换器
//        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
//        rabbitTemplate.setEncoding("UTF-8");
//        // 消息发送失败返回到队列中，yml需要配置 publisher-returns: true
//        rabbitTemplate.setMandatory(true);
//        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
//            String correlationId = message.getMessageProperties().getCorrelationIdString();
//            log.debug("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", correlationId, replyCode, replyText, exchange, routingKey);
//        });
//        // 消息确认，yml需要配置 publisher-confirms: true
//        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
//            if (ack) {
//                log.debug("消息发送到exchange成功,id: {}", correlationData.getId());
//            } else {
//                log.debug("消息发送到exchange失败,原因: {}", cause);
//            }
//        });
//        return rabbitTemplate;
//    }

//    @Bean
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory);
//        template.setMessageConverter(new Jackson2JsonMessageConverter());
//        return template;
//    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        return factory;
    }
}
