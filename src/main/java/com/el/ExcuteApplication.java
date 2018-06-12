package com.el;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;

@Slf4j
@SpringBootApplication(exclude = {
    MongoAutoConfiguration.class,
    MongoDataAutoConfiguration.class,
    ThymeleafAutoConfiguration.class,
    FreeMarkerAutoConfiguration.class,
    })
public class ExcuteApplication {

    public static void main(String[] args) {
        log.info("[APP] Application startup...");
        SpringApplication.run(ExcuteApplication.class, args);
        log.info("[APP] Application started.");
    }

}
