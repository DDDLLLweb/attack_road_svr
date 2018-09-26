package com.el;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
@EnableAutoConfiguration
public class ExcuteApplication {

    public static void main(String[] args) {
        log.debug("[APP] Application startup...");
        SpringApplication.run(ExcuteApplication.class, args);
        log.debug("[APP] Application started.");
    }

}
