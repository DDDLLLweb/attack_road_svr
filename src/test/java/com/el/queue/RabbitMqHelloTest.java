package com.el.queue;

import com.el.app.queue.rabbit.config.RabbitMqConfig;
import com.el.common.AppProperties;
import com.el.core.jdbc.CustomJdbcConfig;
import com.el.core.jdbc.MybatisConfig;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Danfeng
 * @since 2018/9/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(
    initializers = {ConfigFileApplicationContextInitializer.class},
    classes = {CustomJdbcConfig.class, MybatisConfig.class,AppProperties.class,RabbitMqConfig.class}
)
public class RabbitMqHelloTest{

}

