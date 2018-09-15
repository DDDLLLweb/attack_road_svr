package com.el.common;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Data
@Component
@ConfigurationProperties("app")
public class AppProperties implements KeyspaceResolver {

    @Override
    public String sessionSpace() {
        return progId + ":_S_";
    }

    @Override
    public String nonceSpace() {
        return progId + ":_N_";
    }

    @Override
    public String cacheSpace() {
        return progId + ":_C_";
    }

    @Override
    public String queueSpace() {
        return progId + ":_Q_";
    }

    @PostConstruct
    public void postConstruct() {
        log.info("[CORE-APP] appProperties: {}", this);
    }

    /**
     * 应用ID
     */
    private String progId;
    /**
     * 应用部署的节点ID
     */
    private String nodeId;

}
