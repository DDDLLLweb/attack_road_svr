package com.el.app.queue.metaq.config;

import com.taobao.metamorphosis.client.MessageSessionFactory;
import com.taobao.metamorphosis.client.MetaClientConfig;
import com.taobao.metamorphosis.client.MetaMessageSessionFactory;
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
//    public static void main(String[] args) throws Exception {
//
//        final MetaClientConfig metaClientConfig = new MetaClientConfig();
//        final ZkUtils.ZKConfig zkConfig = new ZkUtils.ZKConfig();
//        //设置zookeeper地址
//        zkConfig.zkConnect = "144.202.41.142:2181";
//        metaClientConfig.setZkConfig(zkConfig);
//        // New session factory,强烈建议使用单例
//        MessageSessionFactory sessionFactory = new MetaMessageSessionFactory(metaClientConfig);
//        // create producer,强烈建议使用单例
//        MessageProducer producer = sessionFactory.createProducer();
//        // publish topic
//        final String topic = "test";
//        producer.publish(topic);
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String line = null;
//        while ((line = reader.readLine()) != null) {
//            // send message
//            SendResult sendResult = producer.sendMessage(new Message(topic, line.getBytes()));
//            // check result
//            if (!sendResult.isSuccess()) {
//                System.err.println("Send message failed,error message:" + sendResult.getErrorMessage());
//            }
//            else {
//                System.out.println("Send message successfully,sent to " + sendResult.getPartition());
//            }
//        }
//    }
}
