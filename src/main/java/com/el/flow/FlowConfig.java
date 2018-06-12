package com.el.flow;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author danfeng
 * @since 2018/2/28.
 */
@Slf4j
@Configuration
@EnableProcessApplication
public class FlowConfig {

    @Bean
    public FlowManageService flowManagementService() {
        log.info("[APP-FLOW] flowManageService");
        return new FlowManageService();
    }

}
