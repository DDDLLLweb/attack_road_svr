package com.el.core.security.token;

import com.el.core.security.entity.FormCaptcha;
import lombok.Data;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Danfeng
 * @since 2018/9/15
 */
@Data
public class FormToken implements AuthToken {


    private static final String P_LOGIN_NO = "username";
    private static final String P_PASSWORD = "password";
    private String username;
    private String password;
    private FormCaptcha captcha;

    protected String getLoginNoParamName() {
        return "username";
    }

    protected String getpPasswordParamName() {
        return "password";
    }

    @Override
    public void parse(HttpServletRequest request) {
        this.username = request.getParameter(this.getLoginNoParamName());
        this.password = request.getParameter(this.getpPasswordParamName());
        this.captcha = new FormCaptcha(request);
    }

    @Override
    public boolean ready() {
        return StringUtils.hasText(this.username) && StringUtils.hasText(this.password);
    }

    @Override
    public Object getPrincipal() {
        return this.username;
    }

    @Override
    public Object getCredentials() {
        return this.password;
    }


}
