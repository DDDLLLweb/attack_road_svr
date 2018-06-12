package com.el.security.filters;

import org.apache.shiro.web.filter.mgt.DefaultFilter;

/**
 * @author Danfeng
 * @since 2018/5/24
 */
public class AuthcFilter extends AbstractAuthcFilter {

    protected AuthcFilter(LoginAuthFilter loginAuthFilter) {
        super(loginAuthFilter);
    }

    @Override
    public String getFilterName() {
        return DefaultFilter.authc.name();
    }
}
