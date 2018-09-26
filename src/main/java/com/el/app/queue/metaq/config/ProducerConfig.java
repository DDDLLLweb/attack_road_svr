package com.el.app.queue.metaq.config;

import com.taobao.metamorphosis.client.MessageSessionFactory;
import com.taobao.metamorphosis.client.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 发布者
 *
 * @author Danfeng
 * @since 2018/9/11
 */
@Configuration
public class ProducerConfig {

    @Autowired
    private MessageSessionFactory messageSessionFactory;

    @Bean
    public MessageProducer messageProducer() {
        return messageSessionFactory.createProducer();
    }

}
