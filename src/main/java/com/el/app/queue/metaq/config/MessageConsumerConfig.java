package com.el.app.queue.metaq.config;

import com.el.app.queue.metaq.common.GroupEnum;
import com.el.app.queue.metaq.common.TopicEnum;
import com.el.app.queue.metaq.listener.CommonMsgListener;
import com.taobao.metamorphosis.client.MessageSessionFactory;
import com.taobao.metamorphosis.client.consumer.ConsumerConfig;
import com.taobao.metamorphosis.client.consumer.MessageConsumer;
import com.taobao.metamorphosis.exception.MetaClientException;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消费者
 *
 * @author Danfeng
 * @since 2018/9/11
 */
@Configuration
public class MessageConsumerConfig {
    @Autowired
    private MessageSessionFactory messageSessionFactory;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private CommonMsgListener commonMsgListener;

    @Bean
    public MessageConsumer messageConsumer() throws MetaClientException {
        MessageConsumer consumer = messageSessionFactory.createConsumer(new ConsumerConfig(GroupEnum.meta_test_group.name()));
        consumer.subscribe(TopicEnum.test.name(), 1024, commonMsgListener);
        consumer.completeSubscribe();
        return consumer;
    }
}
