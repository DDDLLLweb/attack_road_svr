package com.el.security.filters;

import com.el.security.checkers.AuthcChecker;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.shiro.SecurityUtils;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author DF
 */
@Slf4j
public abstract class AbstractAuthcFilter extends CustomFilter {

    private final LoginAuthFilter loginAuthFilter;

    protected AbstractAuthcFilter(LoginAuthFilter loginAuthFilter) {
        this.loginAuthFilter = loginAuthFilter;
    }

    @Override
    protected boolean filter(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return confirmAccessState(request, response);

    }

    /**
     * 确认HTTP认证状态
     *
     * @param request  HTTP请求
     * @param response HTTP响应
     * @return HTTP响应状态
     * @throws Exception if an error occurs during processing.
     */
    protected boolean confirmAccessState(
        HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            return loginAuthFilter.executeLogin(request,response);
        } else {
            return false;
        }
    }

    /**
     * 访问拒绝处理
     *
     * @param request  HTTP请求
     * @param response HTTP响应
     * @param status   HTTP响应状态
     * @throws Exception if an error occurs during processing.
     */
    protected void handleAccessDenied(
        HttpServletRequest request, HttpServletResponse response, HttpStatus status) throws Exception {
        response.setStatus(status.value());
    }

}
