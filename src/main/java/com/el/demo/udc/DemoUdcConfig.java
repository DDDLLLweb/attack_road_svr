package com.el.demo.udc;

import com.el.udc.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

/**
 * @author neo.pan
 * @since 17/5/10
 */
@Profile("demo")
@Slf4j
@Configuration
public class DemoUdcConfig {

    @Bean
    public DemoUdcStore udcStore() {
        return new DemoUdcStore();
    }

    @Bean
    public UdcOpService<DemoUdc, DemoUdcItem> udcService(DemoUdcStore store) {
        return new DemoUdcService(store);
    }

    @Bean
    public UdcManager<DemoUdc> udcManager() {
        log.info("[CORE-UDC] udcManager");
        return SimpleUdcManager.of(Arrays.asList(DemoUdc.values()));
    }

    @Bean
    public UdcNameResolver<DemoUdc, DemoUdcItem> udcNameResolver(
        UdcService<DemoUdc, DemoUdcItem> udcService, UdcResolver<DemoUdc> udcResolver) {
        log.info("[CORE-UDC] udcNameResolver");
        return new UdcNameResolver<>(udcService, udcResolver);
    }

}
