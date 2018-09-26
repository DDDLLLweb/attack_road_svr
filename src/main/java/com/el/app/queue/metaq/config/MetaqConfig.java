package com.el.app.queue.metaq.config;

import com.taobao.metamorphosis.client.MessageSessionFactory;
import com.taobao.metamorphosis.client.MetaClientConfig;
import com.taobao.metamorphosis.client.MetaMessageSessionFactory;
import com.taobao.metamorphosis.client.extension.spring.JavaSerializationMessageBodyConverter;
import com.taobao.metamorphosis.client.extension.spring.MetaqTemplate;
import com.taobao.metamorphosis.client.producer.MessageProducer;
import com.taobao.metamorphosis.exception.MetaClientException;
import com.taobao.metamorphosis.utils.ZkUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * metaQ Config
 *
 * @author Danfeng
 * @since 2018/9/7
 */
@Configuration
public class MetaqConfig {

    @ConditionalOnProperty(name = "zk.zkEnable", havingValue = "true")
    @Bean
    public MessageSessionFactory messageSessionFactory() throws MetaClientException {
        final MetaClientConfig metaClientConfig = new MetaClientConfig();
        metaClientConfig.setZkConfig(zkConfig());
        return new MetaMessageSessionFactory(metaClientConfig);
    }

    @Bean
    @ConfigurationProperties(prefix = "zk")
    public ZkUtils.ZKConfig zkConfig() {
        return new ZkUtils.ZKConfig();
    }

    @Bean
    @ConditionalOnBean(MessageSessionFactory.class)
    public MessageProducer messageProducer() throws MetaClientException {
        return messageSessionFactory().createProducer();
    }

    /**
     * 共享MessageProducer
     *
     * @return
     * @throws MetaClientException
     */
    @Bean
    @ConditionalOnBean(MessageSessionFactory.class)
    public MetaqTemplate metaqTemplate() throws MetaClientException {
        MetaqTemplate metaqTemplate = new MetaqTemplate() {{
            setMessageSessionFactory(messageSessionFactory());
            setShareProducer(true);
            setMessageBodyConverter(new JavaSerializationMessageBodyConverter());
        }};
        return metaqTemplate;
    }

}
