package com.el;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;

@Slf4j
@SpringBootApplication
public class ExcuteApplication {

    public static void main(String[] args) {
        log.debug("[APP] Application startup...");
        SpringApplication.run(ExcuteApplication.class, args);
        log.debug("[APP] Application started.");
    }

}
