package com.el.security.filters;

import com.el.domain.OpResult;
import com.el.util.WebUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import static com.el.domain.CoreOp.NG_ACCOUNT;
import static com.el.domain.CoreOp.OK;

/**
 * @author danfeng
 * @since 2018/4/24
 */
@Slf4j
public class LoginAuthFilter extends FormAuthenticationFilter {

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        val result = login(request, response);
        WebUtil.outputResult(response, result);
        return true;
    }

    private OpResult login(ServletRequest request, ServletResponse response) {
        val token = createToken(request, response);
        if (token == null) {
            throw new IllegalStateException("createToken method implementation returned null. " +
                "A valid non-null AuthenticationToken must be created in order to execute a login attempt.");
        }
        log.debug("[CORE-AUTH] token: {}", token);
        try {
            val subject = getSubject(request, response);
            subject.login(token);
            return OK;
        } catch (AuthenticationException e) {
            log.debug("[CORE-AUTH] authc failed because of {}", e.getMessage());
            return NG_ACCOUNT;
        }
    }

    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) {
        WebUtil.outputStatus(response, HttpStatus.UNAUTHORIZED);
    }
}
