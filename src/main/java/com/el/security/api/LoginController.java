package com.el.security.api;

import com.el.domain.OpResult;
import com.el.security.entity.User;
import com.el.util.SecurityUtil;
import com.el.util.WebUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.SessionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.el.domain.CoreOp.NG_ACCOUNT;
import static com.el.domain.CoreOp.OK;

/**
 * @author danfeng
 * @since 2018/4/24
 */
@Slf4j
@RestController
@RequestMapping("${security.apis:/}")
public class LoginController {

    @PostMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) {
       UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword(),user.getRememberMe());
        val subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        try {
            subject.login(token);
            WebUtil.outputResult(response, OK);
        } catch (AuthenticationException e) {
            log.debug("[CORE-AUTH] authc failed because of {}", e.getMessage());
            WebUtil.outputResult(response, NG_ACCOUNT);
        }
    }

    @GetMapping({"/principal"})
    public ResponseEntity principal(HttpServletRequest request) {
        val subject = SecurityUtils.getSubject();
        return subject.isAuthenticated() ? ResponseEntity.ok(subject.getPrincipal()): ResponseEntity.noContent().build();
    }

    @GetMapping("/xsrf")
    public void xsrf(HttpServletRequest request,HttpServletResponse response) {
        SecurityUtil.createXsrfToken(request, response);
    }

    /**
     *
     * @return
     */
    @PostMapping("/logout")
    public ResponseEntity logout() {
        try {
            val subject = SecurityUtils.getSubject();
            if (subject.isAuthenticated()) {
                subject.logout();
            }
        } catch (SessionException ex) {
            log.trace("[CORE-AUTH] Encountered session exception during logout." +
                " This can generally safely be ignored.");
        }
        return WebUtil.toResponseEntity();
    }

}
