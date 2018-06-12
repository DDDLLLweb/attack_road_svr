package com.el.security.config;

import com.el.SecurityProperties;
import com.el.security.checkers.AuthcChecker;
import com.el.security.checkers.RequestChecker;
import com.el.security.entity.SecurityFilterChainsBuilder;
import com.el.security.filters.LoginAuthFilter;
import com.el.security.filters.SecurityFilter;
import com.el.security.realm.CustomRealm;
import com.el.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author danfeng
 * @since 2018/4/24
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class ShiroConfig{

    @Bean
    public FilterRegistrationBean shiroFilterRegistration(SecurityFilter authFilter) {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(authFilter);
        filterRegistration.addInitParameter("targetFilterLifecycle", "true");
        filterRegistration.addUrlPatterns("/*");
        return filterRegistration;
    }

    @Bean
    public SecurityFilter securityFilter(
        SecurityProperties securityProperties, DefaultWebSecurityManager securityManager,
        SecurityFilterChainsBuilder filterChainsBuilder) {
        log.info("[CORE-SEC] securityFilter: {}", securityProperties);
        RequestChecker antiCsrfChecker = r -> !securityProperties.isXsrfEnabled() || SecurityUtil.checkXsrfToken(r);
        return new SecurityFilter(securityManager, filterChainsBuilder.build(), antiCsrfChecker);
    }

    @Bean
    public SecurityFilterChainsBuilder securityFilterChainsBuilder() {
        log.info("[CORE-SEC] securityFilterChainsBuilder");
        return new SecurityFilterChainsBuilder();
    }


    @Bean
    public CustomRealm customRealm() {
        CustomRealm customRealm = new CustomRealm();
        return customRealm;
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        log.info("[CORE-BEAN] shiroSecurityManager");
        return new DefaultWebSecurityManager() {{
            setRealm(customRealm());
        }};
    }

    /**
     *  开启shiro aop注解支持.
     *  使用代理方式;所以需要开启代码支持;
     *  @param securityManager
     *  @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
